<%@ include file="/html/crudtest/init.jsp"%>
<%@ include file="/html/crudtest/popup.jsp" %>

<portlet:actionURL name="removeBook" var="removeBookURL"></portlet:actionURL>
<portlet:actionURL name="updateBook" var="updateBookURL"></portlet:actionURL>

<aui:form action="<%=updateBookURL%>" name="<portlet:namespace/>fm">
	<aui:fieldset>
		<aui:input label="Name" name="Name"
			value="${booksArray[currentBookIndex].name}">
				<aui:validator name="required" errorMessage="Please enter name of the book." />
			</aui:input>
		<aui:select label="Genre" name="Genre">
				<c:forEach var="genre" begin="0" items="${genresArray}" varStatus="status">
					<aui:option value="${genre.genreId}">${genre.name}</aui:option>
				</c:forEach>
		</aui:select>
		<aui:select label="Author" name="Author">
				<c:forEach var="author" begin="0" items="${authorsArray}" varStatus="status">
					<aui:option value="${author.authorId}">${author.name}</aui:option>
				</c:forEach>
		</aui:select>
		<aui:select label="Publisher" name="Publisher">
				<c:forEach var="publisher" begin="0" items="${publishersArray}" varStatus="status">
					<aui:option value="${publisher.publisherId}">${publisher.name}</aui:option>
				</c:forEach>
		</aui:select>
		<aui:input label="Release date" name="ReleaseDate"
			value="${booksArray[currentBookIndex].releaseDate}">
				<aui:validator name="required" errorMessage="Please enter a valid date."/>
		    	<aui:validator name="date"/>	
			</aui:input>
		<aui:input name="BookIndex" value="${currentBookIndex}" type="hidden"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="Save"></aui:button>
		<aui:button onClick="<%= showBooksURL %>" value="Back"></aui:button>
	</aui:button-row>
</aui:form>

<c:if test='${permissionsObject.globalPermissions.add}'>
	<aui:form action="<%=removeBookURL%>" name="deleteForm${currentBookIndex}">
		<aui:fieldset>
			<aui:input name="BookIndex" value="${currentBookIndex}" type="hidden">
			</aui:input>
		</aui:fieldset>
		<aui:button-row>
			<aui:button style="color:red" onClick="javascript:showConfirmation(${currentBookIndex})"
				value="Delete"></aui:button>
		</aui:button-row>
	</aui:form>
</c:if>