<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
   <meta charset="utf-8" />
   <title>Conquer | Admin Dashboard Template</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">

   <%@ include file="../shared/importCss.jsp"%>

   <link rel="shortcut icon" href="favicon.ico" />
</head>

<body class="page-header-fixed">

   <%@ include file="../shared/pageHeader.jsp"%>

   <div class="clearfix"></div>

   <div class="page-container">

      <%@ include file="../shared/sidebarMenu.jsp"%>

      <div class="page-content">

         <%@ include file="../shared/styleSet.jsp"%>

         <!-- BEGIN PAGE HEADER-->
         <div class="row">
            <div class="col-md-12">
               <!-- BEGIN PAGE TITLE & BREADCRUMB-->
               <h3 class="page-title">
                  Dashboard <small>statistics and more</small>
               </h3>
               <ul class="page-breadcrumb breadcrumb">
                  <li>
                     <i class="icon-home"></i>
                     <a href="index.jsp">Home</a>
                     <i class="icon-angle-right"></i>
                  </li>
                  <li><a href="#">Dashboard</a></li>
                  <li class="pull-right">
                     <div id="dashboard-report-range" class="dashboard-date-range tooltips" data-placement="top" data-original-title="Change dashboard date range">
                        <i class="icon-calendar"></i>
                        <span></span>
                        <i class="icon-angle-down"></i>
                     </div>
                  </li>
               </ul>
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
         <div class="clearfix"></div>
         <div class="row"></div>

      </div>
      <!-- END PAGE -->
   </div>
   <!-- END CONTAINER -->

   <%@ include file="../shared/pageFooter.jsp"%>

   <%@ include file="../shared/importJs.jsp"%>

   <!-- BEGIN PAGE LEVEL PLUGINS -->
   <script src="<c:url value='/assets/plugins/gritter/js/jquery.gritter.js'/>" type="text/javascript"></script>
   <!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
   <script src="<c:url value='/assets/plugins/fullcalendar/fullcalendar/fullcalendar.min.js'/>" type="text/javascript"></script>
   <script src="<c:url value='/assets/plugins/jquery.sparkline.min.js'/>" type="text/javascript"></script>
   <!-- END PAGE LEVEL PLUGINS -->
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script src="<c:url value='/assets/scripts/app.js'/>" type="text/javascript"></script>
   <script src="<c:url value='/assets/scripts/index.js'/>" type="text/javascript"></script>
   <!-- END PAGE LEVEL SCRIPTS -->
   <script>
      jQuery(document).ready(function() {    
         App.init(); // initlayout and core plugins
         Index.init();
         Index.initJQVMAP(); // init index page's custom scripts
         Index.initCalendar(); // init index page's custom scripts
         Index.initCharts(); // init index page's custom scripts
         Index.initChat();
         Index.initMiniCharts();
         Index.initPeityElements();
         Index.initKnowElements();
         Index.initDashboardDaterange();
         Tasks.initDashboardWidget();
      });
   </script>
   <!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>