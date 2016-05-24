<%@ include file="/html/crudtest/init.jsp"%>
<%@ include file="/html/crudtest/popup.jsp" %>

<portlet:actionURL name="updateGenre" var="updateGenreURL"></portlet:actionURL>
<portlet:actionURL name="removeGenre" var="removeGenreURL"></portlet:actionURL>

<aui:form action="<%=updateGenreURL%>" name="<portlet:namespace/>fm">
	<aui:fieldset>
		<aui:input label="Name" name="Name"
			value="${genresArray[currentGenreIndex].name}">
				<aui:validator name="required" errorMessage="Please enter name of the genre." />
			</aui:input>
		<aui:input name="GenreIndex" value="${currentGenreIndex}"
			type="hidden"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="Save"></aui:button>
		<aui:button onClick="<%= showGenresURL %>" value="Back"></aui:button>
	</aui:button-row>
</aui:form>


<c:if test='${permissionsObject.globalPermissions.add}'>
	<aui:form action="<%=removeGenreURL%>"
		name="deleteForm${currentGenreIndex}">
		<aui:fieldset>
			<aui:input name="GenreIndex" value="${currentGenreIndex}"
				type="hidden">
			</aui:input>
		</aui:fieldset>
		<aui:button style="color:red" onClick="javascript:showConfirmation(${currentGenreIndex})"
			value="Delete">
		</aui:button>
	</aui:form>
</c:if>