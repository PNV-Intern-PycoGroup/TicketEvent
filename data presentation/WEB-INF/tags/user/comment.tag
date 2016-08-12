<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag pageEncoding="UTF-8"%>

<section class="comment ">
	<div class="content">
		<h1 id="comment-count">Bình luận (<c:choose>
							<c:when test="${event.listComment ne null }"><c:out value="${event.listComment.size() }"></c:out></c:when>
							<c:otherwise>0</c:otherwise>
						</c:choose>)</h1>
		<div class="blog-comment">
			<ul id="contain-comment" class="comments">
				<c:forEach items="${event.listComment }" var="comment">
					<li class="clearfix">
						<div class="post-comments">
							<div class="meta">
								<c:choose>
									<c:when test="${comment.account.userInfor != null && comment.account.userInfor.avatar != null}">
										<img src='<c:url value="/resources/images/avatar/${comment.account.userInfor.avatar }" />' class="avatar" alt="avartar">
									</c:when>
									<c:otherwise>
										<img src='<c:url value="/icon/default_avatar.jpg" />' class="avatar" alt="avatar">
									</c:otherwise>
								</c:choose>
								<p>
									<span><c:out value="${comment.getCommentDateString() }"></c:out></span>
									<a href="#">
										<c:choose>
											<c:when test="${comment.account.userInfor != null && comment.account.userInfor.name != null}">
												<c:out value="${comment.account.userInfor.name }"></c:out>
											</c:when>
											<c:otherwise>
												<c:out value="${comment.account.userName }"></c:out>
											</c:otherwise>
										</c:choose>
									</a> đã bình luận :
								</p>
							</div>
							<p class="comment-content"><c:out value="${comment.content }"></c:out></p>
						</div>
					</li>
				</c:forEach>
			</ul>
			<c:if test="${isNotNullAccount }">
				<h2>Bình Luận của bạn</h2>
				<form action="" class="comment-box">
					<textarea rows="6" id="autosize-textarea-comment"></textarea>
					<button id="btn-comment" class="btn btn-default btn-ticket" type="submit">Bình luận</button>
				</form>
			</c:if>
		</div>
	</div>
</section>