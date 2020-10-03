
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/fragment/meta.jsp"%>
<title>Smartcard</title>
</head>
<body>

	<%@ include file="/fragment/header.jsp"%>

	<div class="container">
		<div align="center">
			<form role="form" action="/Add_SmartCard" method="post">
				<h3 align="center">Please choose the type of card</h3>

				<div class="row">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img id="adult" src="img/adult.jpg" alt="adult smart card">
							<div class="caption">
								<span><input name="adult" value="adult"
									class="btn btn-primary" type="submit" role="Add"></span>
									<%-- <a href="view_smartcard?cardType=${smartcard.cardType}" ></a> --%>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img id="adult" src="img/child.jpg" alt="child smart card">
							<div class="caption">
								<span><input name="smartCardType" name="smartCardType"
									value="child" class="btn btn-primary" type="submit" role="Add"></span>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img id="senior" src="img/senior.jpg" alt="senior smart card">
							<div class="caption">
								<span><input name="senior" value="senior"
									class="btn btn-primary" type="submit" role="Add"></span>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<%@ include file="/fragment/footer.jsp"%>

</body>
</html>