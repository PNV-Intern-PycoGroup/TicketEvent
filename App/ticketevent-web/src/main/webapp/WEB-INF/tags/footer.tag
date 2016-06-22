<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@tag pageEncoding="UTF-8"%>

<link rel="stylesheet" href="resources/css/footer.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">

<footer class="footer">
	<section class="footer-header clearfix">
		<div class="display-table col-sm-6 col-md-3">
			<a href="/how-do-we-help" title="<spring:message code="footer.labelHelp"/>">
				<div class="display-table">
					<div class="table-cell footer-icon">
						<i class="footer-icon fa fa-question-circle"></i>
					</div>
					<div class="table-cell">
						<span class="footer-link"><spring:message code="footer.labelHelp"/></span><br>
						<span><spring:message code="footer.labelHelpDes"/></span>
					</div>
				</div>
			</a>
		</div>
		<div class="col-sm-6 col-md-3">
			<a href="/checkin-app" title="<spring:message code="footer.labelCheckin"/>">
				<div class="display-table">
					<div class="table-cell footer-icon">
						<i class="footer-icon fa fa-question-circle"></i>
					</div>
					<div class="table-cell">
						<span class="footer-link"><spring:message code="footer.labelCheckin"/></span><br> 
						<span><spring:message code="footer.labelCheckinDes"/></span>
					</div>
				</div>
			</a>
		</div>
		<div class="ft-link col-sm-6 col-md-3">
			<a href="/help-center" title="FAQ" class="table center valign-middle">
				<div class="display-table">
					<div class="table-cell footer-icon">
						<i class="footer-icon fa fa-comments-o"></i>
					</div>
					<div class="table-cell">
						<span class="footer-link">FAQ</span><br> <span><spring:message code="footer.labelFAQDes"/></span>
					</div>
				</div>
			</a>
		</div>
		<div class="ft-link col-sm-6 col-md-3">
			<a href="/contact" title="<spring:message code="footer.labelContact"/>" class="table center valign-middle">
				<div class="display-table">
					<div class="table-cell footer-icon">
						<i class="footer-icon fa fa fa-phone"></i>
					</div>
					<div class="table-cell">
						<span class="footer-link"><spring:message code="footer.labelContact"/></span><br> <span><spring:message code="footer.labelContactDes"/>: 01637785816</span>
					</div>
				</div>
			</a>
		</div>
	</section>

	<section class="footer-body clearfix">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-sm-6 col-md-3">
					<div class="fbody-head">Hotline</div>
						<ul class="our-links">
							<li><spring:message code="labelHCM"/>: <a class="ft-hotline"
								href="tel:+84873007998"><strong class="tkb-color">08.7300.7998</strong>
									(8:30 AM - 7:30 PM)</a>
							</li>
							<li><spring:message code="labelHN"/>: <a class="ft-hotline" href="tel:+84947119705"><strong
									class="tkb-color">094.711.9705</strong> (9:30 AM - 6:30 PM)</a>
							</li>
						</ul>
				</div>
				<div class="col-sm-6 col-md-3 fbody-block">
					<div class="fbody-head"><spring:message code="footer.labelREmail"/></div>
					<form:form action="sentEmail" method= "POST">
					<div class="input-email input-group input-group-size">
						<span
							class="input-group-addon input-group-fix-color input-group-fix-border-right"><i
							class="fa fa-envelope"></i></span> <input type="text"
							class="form-control input-group-fix-color input-group-fix-border-right input-group-fix-border-left"
							aria-label="Amount (to the nearest dollar)"><span
							class="input-group-btn input-group-size">
							<button
								class="btn btn-secondary input-group-fix-color input-group-fix-border-left"
								type="submit">
								<i class="fa fa-arrow-right" aria-hidden="true"></i>
							</button>
						</span>
					</div></form:form>
				</div>
				<div class="col-sm-6 col-md-3 fbody-block">
					<div class="fbody-head"><spring:message code="footer.labelInApp"/></div>
					<div class="fbody-content"></div>
				</div>
				<div class="col-sm-6 col-md-3 fbody-block">
					<span class="fbody-head"><spring:message code="footer.labelAbout1"/></span>
					<div class="fbody-content">
						<ul class="our-links">
							<li><a href="/about-us"
								title="<spring:message code="footer.labelAbout2"/> TicketBox"><spring:message code="footer.labelAbout2"/> TicketEvent</a></li>
							<li><a href="/jobs" title="<spring:message code="footer.labelJobFuture"/>"><spring:message code="footer.labelJobFuture"/></a></li>
							<li><a href="/term-and-policy"
								title="<spring:message code="footer.labelRules"/>"><spring:message code="footer.labelRules"/></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="row">
				<div class="col-sm-6 col-md-3 fbody-block">
					<div class="fbody-head"><spring:message code="footer.labelAddress"/></div>
					<!-- <div class="fbody-cta"> -->
						<a class = "address" href="/contact"><spring:message code="footer.labelAddressDes"/></a>
					<!-- </div> -->
				</div>
				<div class="col-sm-6 col-md-3">
					<div class="fbody-head"><spring:message code="footer.labelFollow"/></div>
					<div class="social-media-fix">
						<div class="sm-facebook">
							<a
								href="http://www.facebook.com/sharer.php?u=https://simplesharebuttons.com"
								target="_blank"> <i class="fa fa-facebook"></i>
							</a>
						</div>

						<div class="sm-google-plus">
							<a
								href="http://www.plus.google.com/sharer.php?u=https://simplesharebuttons.com"
								target="_blank"><i class="fa fa-google-plus"></i>
							</a>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-3">
					<!-- languages -->
					<div>
						<div class="fbody-head"><spring:message code="label.Language"/></div>
						<div class="social-media-fix">
							<div class="flag-vn">
								<a href='?lang=vi'> <img src="resources/icon/flag_vn.png"></img></a>
							</div>
							<div class="flag-en">
								<a href="?lang=en"> <img src="resources/icon/flag_en.png"></img></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="footer-footer clearfix">
		<div class="col-sm-6">
			<div class="display-table">
				<div class="ft-img table-cell">
					<img src="resources/icon/icon2.svg">
				</div>
				<div class="ftft-left">
					<spring:message code="footer.left"/> <br>
					TicketEvent Co. Ltd. © 2016
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div>
				<div class="ftft-right hidden-xs"><spring:message code="footer.right"/></div>
			</div>
		</div>

	</section>
</footer>