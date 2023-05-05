
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Enter Target Details</h1>
	<form:form method="post" modelAttribute="target">
		<fieldset class="mb-3">
			<!-- mb stands for margin at the bottom of the field -->
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="startDate">Start Date</form:label>
			<form:input type="text" path="startDate" />
			<form:errors path="startDate" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="mb-3">
			<form:label path="endDate">Start Date</form:label>
			<form:input type="text" path="endDate" />
			<form:errors path="endDate" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="mb-3">
			<!-- mb stands for margin at the bottom of the field -->
			<form:label path="outcome">Reported Outcome</form:label>
			<form:input type="text" path="outcome" />
			<form:errors path="outcome" cssClass="text-warning" />
		</fieldset>

		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="active" />
		<input type="submit" class="btn btn-success" />

	</form:form>
</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>
