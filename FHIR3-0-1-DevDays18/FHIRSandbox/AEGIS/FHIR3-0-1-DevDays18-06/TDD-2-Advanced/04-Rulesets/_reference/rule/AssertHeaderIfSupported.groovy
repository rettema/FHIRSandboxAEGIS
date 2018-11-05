/*
 	rule.summary=${label.target} '${param.header}' header ${param.headerOperator} if ${param.confPathLabel} is supported by ${label.confStmt} conformance statement.
 	rule.description=Confirm that '${param.header}' header ${param.headerOperator} in ${label.target} if ${param.confPathLabel} is supported by ${label.confStmt} conformance statement.
 	rule.param.header.required=true
 	rule.param.headerExpectedValue.required=false
 	rule.param.headerOperator.required=true
 	rule.param.confFhirPath.required=false
 	rule.param.confXPath.required=false
 	rule.param.confJsonPath.required=false
 	rule.param.confOperator.required=false
 	rule.param.confPathValue.required=false
 	rule.param.confPathLabel.required=true
*/
assert !param.header.is(null): "The parameter 'header' was not supplied"
assert !param.headerOperator.is(null): "The parameter 'headerOperator' was not supplied"
assert param.confFhirPath || param.confXPath || param.confJsonPath: "One of the parameters ['confFhirPath','confXPath','confJsonPath'] must be supplied"

boolean headerPresent = !targetMessage.getHeader(param.header).is(null)

// Evaluate the header if it's present regardless of whether the conformance statement supports it or not.
// Perform this check before incurring the overhead of conformance statement evaluation
if (headerPresent) {
	assertHeader(param.header, param.headerExpectedValue, param.headerOperator, targetMessage);
} else {
	// Evaluate the conformance supported; if true, proceed with header assert
	ifSupported("Header", param.confFhirPath, param.confXPath, param.confJsonPath, param.confPathValue, param.confOperator, param.confPathLabel, confStmt).proceed();
	assertHeader(param.header, (String)param.headerExpectedValue, param.headerOperator, targetMessage);
}
