<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>

   <div class="container">
      <h2>사진 게시판</h2>
      <table class="table table-bordered">
         <thead>
            <tr>
               <td>번호</td>
               <td>제목</td>
               <td>미리보기</td>
               <td>날짜</td>
               <td>시간</td>
            </tr>
         </thead>
         <c:if test="${empty pbList }">
            <tr>
               <td>내용이없습니다</td>
            </tr>
         </c:if>
         <c:if test="${!empty pbList }">
            <c:forEach items="${pbList }" var="pb">
               <tbody>
                  <tr>
                     <td>${pb.pbNum }</td>
                     <td>${pb.pbTitle }</td>
                     <td>${pb.pbContent }</td>
                     <td><img src="/resources/${pb.pbPhotoPath }" width="50px"
                        onmouseover="showImg(this.src)" onmouseout="offImg()"></td>
                     <td>${pb.credat }</td>
                  </tr>
               </tbody>
            </c:forEach>
         </c:if>

      </table>
      <c:forEach begin="${page.startBlock}" end="${page.endBlock }" var="idx">
         <a href="/photo/list?page.pageNum=${idx}">[${idx}]</a>
      </c:forEach>
      <a href="/photo/list?page.pageNub=${page.pageNum+1}">▶</a>
      <a href="/photo/write"><button class="btn btn-primary">글쓰기</button></a>
      <div class="text-left">
         <ul class="pagination">
            <li><a href="#">1</a>
            <li><a href="#">2</a>
            <li><a href="#">3</a>
            <li><a href="#">4</a>
            <li><a href="#">5</a>
         </ul>
      </div>
   </div>
   <img src="" style="display: none" id="sImg">
   <script>
      function showImg(src) {
         document.querySelector("#sImg").src = src;
         document.querySelector("#sImg").style.display = '';
      }
      function offImg() {
         document.querySelector("#sImg").style.display = "none";
      }
   </script>
</body>
</html>