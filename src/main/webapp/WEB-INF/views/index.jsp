<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%@ include file="./layout/header.jsp"%>
<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-4">
            <h2>About Me</h2>
            <h5>Photo of me:</h5>
            <div class="fakeimg">Fake Image</div>
            <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
            <h3>Some Links</h3>
            <p>Lorem ipsum dolor sit ame.</p>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <hr class="d-sm-none">
        </div>

            <div class="col-sm-8">
                <c:forEach var="board" items="${boards.content}">
                <div class="card-body">
                    <h4 class="card-title">${board.title}</h4>
<%--                    <p class="card-text">${board.content}</p>--%>
                    <a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
                </div>
                </c:forEach>
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${boards.first}">
                            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${boards.last}">
                            <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>



    </div>
</div>
<%@ include file="./layout/footer.jsp"%>



