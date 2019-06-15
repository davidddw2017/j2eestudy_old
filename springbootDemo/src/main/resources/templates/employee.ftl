<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>SpringBoot AdminLTE 2 Example</title>
	<!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="icon" type="image/x-icon" href="static/favicon.ico">
	<link rel="stylesheet" href="webjars/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="webjars/font-awesome/4.7.0/css/font-awesome.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="webjars/ionicons/2.0.1/css/ionicons.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="webjars/AdminLTE/2.4.10/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="webjars/AdminLTE/2.4.10/dist/css/skins/skin-blue.min.css">

	<style>
	button {
		background: none;
		border: none;
	}
	
	.btn-del {
		float: right;
		margin-right: 10px;
		color: #000;
		font-weight: normal;
	}
	</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
	    <!-- Main Header -->
        <header class="main-header">
	        <!-- Logo -->
	        <a href="#" class="logo">
	            <!-- mini logo for sidebar mini 50x50 pixels -->
	            <span class="logo-mini"><b>A</b>LT</span>
	            <!-- logo for regular state and mobile devices -->
	            <span class="logo-lg"><b>Admin</b>LTE</span>
	        </a>
	
	        <!-- Header Navbar -->
	        <nav class="navbar navbar-static-top" role="navigation">
	            <!-- Sidebar toggle button-->
	            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
	                <span class="sr-only">Toggle navigation</span>
	            </a>
	            <!-- Navbar Right Menu -->
	            <div class="navbar-custom-menu">
	                <ul class="nav navbar-nav">
	                    <!-- Control Sidebar Toggle Button -->
	                    <li>
	                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
	                    </li>
	                </ul>
	            </div>
	        </nav>
        </header>
		<!-- Left side column. contains the logo and sidebar -->
    	<aside class="main-sidebar">
    		<!-- sidebar: style can be found in sidebar.less -->
        	<section class="sidebar">

	            <!-- Sidebar Menu -->
	            <ul class="sidebar-menu" data-widget="tree">
	                <li class="header">平台功能</li>
	                <!-- Optionally, you can add icons to the links -->
	                <li class="active"><a href="#"><i class="fa fa-link"></i> <span>客户管理</span></a></li>
	                <li><a href="#"><i class="fa fa-link"></i> <span>订单管理</span></a></li>
	                <li class="treeview">
	                    <a href="#"><i class="fa fa-link"></i> <span>管理员管理</span>
	                    <span class="pull-right-container">
	                		<i class="fa fa-angle-left pull-right"></i>
	              		</span>
	                    </a>
	                    <ul class="treeview-menu">
	                        <li><a href="#">管理账号管理</a></li>
	                        <li><a href="#">管理角色管理</a></li>
	                    </ul>
	                </li>
	            </ul>
            	<!-- /.sidebar-menu -->
        	</section>
        	<!-- /.sidebar -->
    	</aside>

    	<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
		    <!-- Content Header (Page header) -->
       		<section class="content-header">
            	<h1>
                	SpringBoot Json example
            	</h1>
        	</section>
        	
        	<!-- Main content -->
	        <section class="content container-fluid">
	        	<div class="row">
	        	    <div class="col-md-12">
		        		<div class="box box-primary">
		                	<div class="box-header with-border">
		                    	<h3 class="box-title">Spring Boot + WebJars + AdminLTE 2.x</h3>
		                    </div>
		                	<!-- /.box-header -->
				            <form id="form" action="" class="form-horizontal">
								<div class="box-body">
				                	<div class="form-group">
	                  					<label for="name" class="col-sm-2 control-label">Name: </label>
							            <div class="col-sm-10">
	                    					<input type="text" class="form-control" name="name" id="name" placeholder="Name">
	                  					</div>
	                				</div>
	                				<div class="form-group">
	                  						<label for="address" class="col-sm-2 control-label">Address: </label>
							                <div class="col-sm-10">
	                    						<input type="text" class="form-control" name="address" id="address" placeholder="Address">
	                  						</div>
	                				</div>
	                				<div class="form-group">
	                  						<label for="age" class="col-sm-2 control-label">Age: </label>
							                <div class="col-sm-10">
	                    						<input type="text" class="form-control" name="age" id="age" placeholder="Age">
	                  						</div>
	                				</div>
								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="submit" id="submit" class="btn btn-primary">Submit</button>
		              			</div>
	              				<!-- /.box-footer-->
							</form>
		            	</div>
		            	<!-- /.box -->
		            	<div class="box box-danger">
				           	<div class="box-header">
				              	<h3 class="box-title">All Employee</h3>
				            </div>
				            <!-- /.box-header -->
				            <div class="box-body" id="output"></div>
				            <!-- /.box-body -->
				        </div>
				        <!-- /.box-end -->
		            </div>
	        	</div>
	        </section>
	        <!-- /.content -->
		</div>
    	<!-- /.content-wrapper -->
    	<!-- Main Footer -->
	    <footer class="main-footer">
	        <!-- To the right -->
	        <div class="pull-right hidden-xs">
	            Anything you want
	        </div>
	        <!-- Default to the left -->
	        <strong>Copyright &copy; 2019 <a href="#">Company</a>.</strong> All rights reserved.
	    </footer>
	</div>
	<!-- jQuery 3 -->
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="static/js/custom.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="webjars/AdminLTE/2.4.10/dist/js/adminlte.min.js"></script>
</body>
</html>