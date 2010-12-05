<form name="groupTO"  method="POST" action="groups.htm">
	<table style="width: 500px;"  border="0" align="center">
		<tbody>
			<tr>
				<td colspan="2" style="width: 100px;" align="center"><H3>Add a group</H3></td>
			</tr>
			<tr>
				<td style="width: 100px;" >Name</td>
				<td >
					<spring:bind path="groupTO.name">
						<input type="text" name="${status.expression}"  maxlength="50" style="width:128px;" value="<c:out value='${status.value}' escapeXml='true'/>" >
					</spring:bind>
				</td>
			</tr>


			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="submit" value="Submit">
					<input type="reset" name="reset" value="Reset">
				</td>
			</tr>
		</tbody>
	</table>
</form>