<div class="my-layout" id="main-content" role="main">
	<div class="portlet-layout row-fluid">
	
        <div class="portlet-column portlet-column-first span8" id="column-2">
        	$processor.processPortlet("crudtest_WAR_crudtestportlet")
            $processor.processColumn("column-2", "portlet-column-content portlet-column-content-first")
        </div>

        <div class="portlet-column portlet-column-last span4" id="column-3">
            $processor.processColumn("column-3", "portlet-column-content portlet-column-content-last")
        </div>
    </div>
	<div class="portlet-layout  row-fluid">
		<div class="portlet-column portlet-column-only" id="column-4">
			$processor.processColumn("column-4", "portlet-column-content portlet-column-content-only")
		</div>
	</div>
</div>