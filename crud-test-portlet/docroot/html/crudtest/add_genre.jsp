<%@ include file="/html/crudtest/init.jsp"%>

<portlet:actionURL name="addGenre" var="addGenreURL"></portlet:actionURL>

<aui:form action="<%=addGenreURL%>" name="<portlet:namespace/>fm">
	<aui:fieldset>
		<aui:input label="Name" name="Name">
			<aui:validator name="required" errorMessage="Please enter name of the genre." />
		</aui:input>
		<aui:field-wrapper label="permissions">
			<liferay-ui:input-permissions
				modelName="<%= Genre.class.getName() %>"
			/>
		</aui:field-wrapper>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" value="Add"></aui:button>
		<aui:button onClick="<%= showGenresURL %>" value="Back"></aui:button>
	</aui:button-row>
</aui:form>