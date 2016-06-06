<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List"%>
<%@ page import="java.lang.String"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.test.portlet.model.*"%>
<%@ page import="com.liferay.test.portlet.service.*"%>

<portlet:defineObjects />
<theme:defineObjects />

 <script>
 	$(document).ready(function() { $('#DataTable').DataTable(); } );
 </script>
 
<portlet:renderURL var="showBooksURL">
	<portlet:param name="mvcPath" value="/html/crudtest/show_books.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="showAuthorsURL">
	<portlet:param name="mvcPath" value="/html/crudtest/show_authors.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="showPublishersURL">
	<portlet:param name="mvcPath" value="/html/crudtest/show_publishers.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="showGenresURL">
	<portlet:param name="mvcPath" value="/html/crudtest/show_genres.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:error key="dateError" message="The date is not in proper format (mm.dd.yy)" />
<liferay-ui:error key="idError" message="Error while finding an id" />
<liferay-ui:error key="addError" message="Error while adding an instance" />
<liferay-ui:error key="deleteError" message="Error while deleting an instance" />
<liferay-ui:error key="deleteError" message="Error while updating an instance" />
<liferay-ui:error key="getInfoError" message="Error while collecting data from database" />
<liferay-ui:error key="resourceAddError" message="Error while adding a resource" />
<liferay-ui:error key="permissionsUpdateError" message="Error while updating permissions" />

<aui:button-row>
	<aui:button onClick="<%= showBooksURL %>" value="Books"></aui:button>
	<aui:button onClick="<%= showAuthorsURL %>" value="Authors"></aui:button>
	<aui:button onClick="<%= showGenresURL %>" value="Genres"></aui:button>
	<aui:button onClick="<%= showPublishersURL %>" value="Publishers"></aui:button>
</aui:button-row>
