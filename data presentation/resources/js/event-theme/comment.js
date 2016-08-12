$(function() {
	// Comment
	var eventId = $('#event-id').val();
	var textareaComment = $('#autosize-textarea-comment');
	if (textareaComment.length > 0) {
		var autoSizeTextareaComment = document.querySelector('#autosize-textarea-comment');
		autoSizeTextareaComment.addEventListener('focus', function(){
		    autosize(autoSizeTextareaComment);
		});
		
		
		Date.prototype.toString = function() {
		  var result = (this.getDate() < 10 ? '0' : '') + this.getDate() + '/' + (this.getMonth() < 9 ? '0' : '') + (this.getMonth() + 1) + '/' + this.getFullYear() ;
		  return result;
		}
		var containComment = $('#contain-comment');
		var btnComment = $('#btn-comment');
		var commentCount = $('#comment-count');
		
		var showDialogError = function(message, time) {
			$.notify(
				{icon: 'glyphicon glyphicon-warning-sign', message: message },
				{type: "danger", delay: time, z_index: 1100}
			);
		};

		var showDialogSuccess = function(message, time) {
			$.notify(
				{icon: 'glyphicon glyphicon-ok', message: message },
				{type: "success", delay: time, z_index: 1100}
			);
		};
		
		var loadingComment;
		loadingComment = loadingComment || (function () {
		    var btnComment = $('#btn-comment');
		    var iconLoading = $('<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>');
		    return {
		        showPleaseWait: function() {
		            btnComment.text('');
		            btnComment.append(iconLoading);
		        },
		        hidePleaseWait: function () {
		            btnComment.find(iconLoading).remove();
		            btnComment.text('Bình luận');
		        },

		    };
		})();
		
		var commentFactory;
		commentFactory = commentFactory || (function() {
			var commentHtml="";
			commentHtml += "<li class=\"clearfix\">";
			commentHtml += "	<div class=\"post-comments\">";
			commentHtml += "		<div class=\"meta\">";
			commentHtml += "			<img src=\"/ticketevent-web/resources/icon/default_avatar.jpg\" class=\"avatar\" alt=\"avatar\">";
			commentHtml += "			<p>";
			commentHtml += "				<span><\/span> <a href=\"#\"><\/a> đã bình luận :";
			commentHtml += "			<\/p>";
			commentHtml += "		<\/div>";
			commentHtml += "		<p class=\"comment-content\"><\/p>";
			commentHtml += "	<\/div>";
			commentHtml += "<\/li>";
			
			return {
		        getBlockComment: function(addCommentContext) {
		        	debugger;
		            var blockComment = $(commentHtml);
		            var avatar = blockComment.find('img');
		            var dateComment = blockComment.find('span');
		            var userComment = blockComment.find('a');
		            var commentContent = blockComment.find('.comment-content');
		            
		            var userName = '';
		            if (addCommentContext.nameUserInfo === null) {
						userName = addCommentContext.userName;
					}else {
						userName = addCommentContext.nameUserInfo;
					}
		            if (addCommentContext.avatar !== null) {
		            	avatar.attr('src', '/ticketevent-web/resources/images/avatar/' + addCommentContext.avatar);
					}
		            
		            dateComment.text(new Date(addCommentContext.commentDate).toString());
		            userComment.text(userName);
		            commentContent.text(addCommentContext.content);
		            
		            return blockComment;
		        }
		    };
		})();
		var addComment = function() {
			loadingComment.showPleaseWait();
			var comment = {
				content: textareaComment.val() == '' ? null : textareaComment.val(),
				event: eventId == '' ? null : {id: eventId}
			};
			$.ajax({
			    type: 'POST',
			    url: "/ticketevent-web/add-comment",
			    contentType : 'application/json; charset=utf-8',
		     	dataType : 'text',
			    data : JSON.stringify(comment)
			})
			.done(function(data) {
				loadingComment.hidePleaseWait();
				if (data === 'sendDataError') {
			 		showDialogError('Dữ liệu gửi bị lỗi.', 5000);
				}else if (data === 'convertJsonError') {
			 		showDialogError('Server convert object error.', 5000);
				}else if (data === 'loginError') {
					var url = window.location.href;
					if (url.includes('event/')) {
						window.location.replace('/ticketevent-web/login/event+' + url.substring(url.lastIndexOf('/') + 1));
					}else {
						window.location.replace('/ticketevent-web/login/');
					}
				}else {
					textareaComment.val('');
					var commentContext = JSON.parse(data);
					var blockComment = commentFactory.getBlockComment(commentContext);
					blockComment.hide();
					containComment.append(blockComment);
					blockComment.fadeIn(500);
					commentCount.text('Bình luận ( ' + $('#contain-comment').find('li').length + ' )')
				}
			})
			.fail(function(xhr) {
				loadingComment.hidePleaseWait();
				if (xhr.status === 404) {
					window.location.replace('/ticketevent-web/error/404');
				}else if (xhr.status === 403) {
					var url = window.location.href;
					if (url.includes('event/')) {
						window.location.replace('/ticketevent-web/login/event+' + url.substring(url.lastIndexOf('/') + 1));
					}else {
						window.location.replace('/ticketevent-web/login/');
					}
				}
			});
		}
		btnComment.click(function(e) {
			e.preventDefault();
			addComment();
		});
	}
	// end comment
});