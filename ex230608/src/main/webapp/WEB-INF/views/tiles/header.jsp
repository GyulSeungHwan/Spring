<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- contextPath를 끌고오는것(/(루트) 앞에 적어주지않으면 contextPath를 제외하고 경로를 찾는다) -->
<!-- contextPath는 동적으로 움직이기 때문에 경로에 포함이 될수도 포함이 안될수도 있다 -->
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary { -
	-bd-violet-bg: #712cf9; -
	-bd-violet-rgb: 112.520718, 44.062154, 249.437846; -
	-bs-btn-font-weight: 600; -
	-bs-btn-color: var(- -bs-white); -
	-bs-btn-bg: var(- -bd-violet-bg); -
	-bs-btn-border-color: var(- -bd-violet-bg); -
	-bs-btn-hover-color: var(- -bs-white); -
	-bs-btn-hover-bg: #6528e0; -
	-bs-btn-hover-border-color: #6528e0; -
	-bs-btn-focus-shadow-rgb: var(- -bd-violet-rgb); -
	-bs-btn-active-color: var(- -bs-btn-hover-color); -
	-bs-btn-active-bg: #5a23c8; -
	-bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
	z-index: 1500;
}
</style>
<!-- Custom styles for this template -->
<link href="headers.css" rel="stylesheet">
</head>
<body>
	<div class="px-3 py-2 text-bg-dark border-bottom">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/"
					class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
					<svg class="bi me-2" width="40" height="32" role="img"
						aria-label="Bootstrap">
						<use xlink:href="#bootstrap" /></svg>
				</a>

				<ul
					class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
					<li><a href="#" class="nav-link text-secondary"> <svg
								class="bi d-block mx-auto mb-1" width="24" height="24">
								<use xlink:href="#home" /></svg> Home
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi d-block mx-auto mb-1" width="24" height="24">
								<use xlink:href="#speedometer2" /></svg> Dashboard
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi d-block mx-auto mb-1" width="24" height="24">
								<use xlink:href="#table" /></svg> Orders
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi d-block mx-auto mb-1" width="24" height="24">
								<use xlink:href="#grid" /></svg> Products
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi d-block mx-auto mb-1" width="24" height="24">
								<use xlink:href="#people-circle" /></svg> Customers
					</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="px-3 py-2 text-bg-dark border-bottom">
		<div class="container d-flex flex-wrap justify-content-center">
			<form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto"
				role="search">
				<input type="search" class="form-control" placeholder="Search..."
					aria-label="Search">
			</form>

			<div class="text-end">
				<button type="button" class="btn btn-btn btn-outline-light me-2">Login</button>
				<button type="button" class="btn btn-warning">Sign-up</button>
			</div>
		</div>
	</div>
</body>
</html>