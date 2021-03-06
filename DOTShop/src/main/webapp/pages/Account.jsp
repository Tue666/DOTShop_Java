<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags"%>
<%@ include file="/common/taglib.jsp"%>
<l:MainLayout title="Account | DOT Shop">
	<jsp:body>
	<div class="main-container">
	<main class="container">
		<header class="row">
			<div class="row">
				<div class="alert alert-success">
					<h1>Account Information</h1>
				</div>

			</div>
		</header>
		<section class="row">
			<div class="col-5">
				<div class="row">
					<div class="col">
						<form action="/DOTShop/account" method="POST">
							<div class="form-group">
								<label for="name"> Name: </label> <input type="text" id="name"
											name="name" class="form-control" placeholder="Enter name"
											 value=${account.getName()} >
							</div>
							<div class="form-group">
								<label for="gender">Gender: </label>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input"value="Male" id="male"
												name="gender" ${account.getGender() == "Male" ? "checked" : ""} /> <label
												for="male">Male</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" value="Female" id="female"
												name="gender" ${account.getGender() == "Female" ? "checked" : ""} /> <label
												for="female">Female</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" value="Other" id="other"
												name="gender" ${account.getGender() != "Female" && account.getGender() != "Male" ? "checked" : ""} /> <label
												for="other">Other</label>
								</div>
							</div>
							<div class="form-group">
								<label for="address">Address: </label> <input type="text"
											name="address" class="form-control" id="address" placeholder="Enter address"
											value=${account.getAddress()} >
							</div>
	
							<div class="form-group">
								<label for="email">Email: </label> <input class="form-control"
											type="text" id="email" name="email" placeholder="Enter email"
											value=${account.getEmail()} >
							</div>
							<hr />
							<button type="submit" class="btn btn-primary">Update</button>
							
						</form>
					</div>
				</div>
			</div>
		</section>
	</main>
	</div>
</jsp:body>
</l:MainLayout>