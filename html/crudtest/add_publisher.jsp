<%@ include file="/html/crudtest/init.jsp"%>

<portlet:actionURL name="addPublisher" var="addPublisherURL"></portlet:actionURL>

<aui:form action="<%=addPublisherURL%>" name="<portlet:namespace/>fm">
	<aui:fieldset>
		<aui:input label="Name" name="Name">
			<aui:validator name="required" errorMessage="Please enter name of the publisher." />
		</aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="Add"></aui:button>
		<aui:button onClick="<%= showPublishersURL %>" value="Back"></aui:button>
	</aui:button-row>
</aui:form>