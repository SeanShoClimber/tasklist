<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/appfortask.jsp">
    <c:param name="content">

        <h2> id: ${TasksDTO.id}のタスク詳細ページ</h2>

        <p>タスク内容: <c:out value="${TasksDTO.content}"/></p>
        <p>作成日時: <fmt:formatDate value="${TasksDTO.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <p>更新日時: <fmt:formatDate value ="${TasksDTO.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a> </p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${TasksDTO.id}">このタスクを編集する</a></p>
    </c:param>
</c:import>