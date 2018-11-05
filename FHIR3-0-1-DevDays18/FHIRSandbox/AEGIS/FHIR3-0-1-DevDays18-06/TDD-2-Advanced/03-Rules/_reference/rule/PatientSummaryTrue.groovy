/*
 	rule.summary=FHIR3-0-1-DevDays17 - Patient - Test Patient resource response body contents for conformance to _summary=true
 	rule.description=Verify that the Patient resource only contains _summary=true elements
*/
boolean hasNonSummaryEntries = false
String nonSummaryEntries = ""

assert contentType=='JSON' || contentType=='XML': "Expected JSON or XML in message body"

if (contentType=='JSON') {
	assert !body.resourceType.is(null) && !body.resourceType.isEmpty(): "Could not find resourceType in message body"
	assert body.resourceType.equals('Patient'): "Expected Patient resource in response but found '"+body.resourceType+"'"

	// Attempt to find all Resource non-summary elements that are not empty.
	if (body.language) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "language" }

	// Attempt to find all DomainResource non-summary elements that are not empty.
	if (body.text) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "text" }
	if (body.contained) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "contained" }
	if (body.extension) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "extension" }
	if (body.modifierExtension) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "modifierExtension" }

	// Attempt to find all Patient non-summary elements that are not empty.
	if (body.maritalStatus) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "maritalStatus" }
	if (body.multipleBirthBoolean) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "multipleBirthBoolean" }
	if (body.multipleBirthInteger) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "multipleBirthInteger" }
	if (body.photo) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "photo" }
	if (body.contact) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "contact" }
	if (body.communication) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "communication" }
	if (body.generalPractitioner) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "generalPractitioner" }
}
else {
	assert !body.name().is(null) && !body.name().isEmpty(): "Could not find resource in message body"
	assert body.name().equals('Patient'): "Expected Patient resource in response but found '"+body.name()+"'"

	// Attempt to find all Resource non-summary elements that are not empty.
	if (!body.language.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "language" }

	// Attempt to find all DomainResource non-summary elements that are not empty.
	if (!body.text.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "text" }
	if (!body.contained.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "contained" }
	if (!body.extension.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "extension" }
	if (!body.modifierExtension.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "modifierExtension" }

	// Attempt to find all Patient non-summary elements that are not empty.
	if (!body.maritalStatus.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "maritalStatus" }
	if (!body.multipleBirthBoolean.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "multipleBirthBoolean" }
	if (!body.multipleBirthInteger.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "multipleBirthInteger" }
	if (!body.photo.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "photo" }
	if (!body.contact.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "contact" }
	if (!body.communication.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "communication" }
	if (!body.generalPractitioner.isEmpty()) { hasNonSummaryEntries = true; nonSummaryEntries += nonSummaryEntries ? ", " : ""; nonSummaryEntries += "generalPractitioner" }
}

assert !hasNonSummaryEntries: "Non-summary element(s) found in Patient resource! [" + nonSummaryEntries + "]"
