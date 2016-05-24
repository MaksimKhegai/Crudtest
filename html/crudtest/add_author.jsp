<%@ include file="/html/crudtest/init.jsp"%>

<portlet:actionURL name="addAuthor" var="addAuthorURL"></portlet:actionURL>

<aui:form action="<%=addAuthorURL%>" name="<portlet:namespace/>fm">
	<aui:fieldset>
		<aui:input label="Name" name="Name">
			<aui:validator name="required" errorMessage="Please enter name of the author." />
		</aui:input>
		<aui:input label="Birth date" name="BirthDate">
			<aui:validator name="required" errorMessage="Please enter a valid date."/>
		    <aui:validator name="date"/>
		</aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="Add"></aui:button>
		<aui:button onClick="<%= showAuthorsURL %>" value="Back"></aui:button>
	</aui:button-row>
</aui:form>