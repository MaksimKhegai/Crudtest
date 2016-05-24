<aui:script use="aui-dialog">
	window.showConfirmation = function(id) {
		if (confirm("Are you sure you want to delete this item?")) {
			document.forms["<portlet:namespace/>deleteForm" + id].submit();
		}
		;
	}
</aui:script>