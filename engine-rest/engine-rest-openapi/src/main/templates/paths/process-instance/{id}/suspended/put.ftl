{

  <@lib.endpointInfo
      id = "updateSuspensionStateById"
      tag = "Process instance"
      desc = "Activates or suspends a given process instance by id." />

  "parameters" : [ 
      <@lib.parameter
        name = "id"
        location = "path"
        type = "string"
        required = true
        last = true
        desc = "The id of the process instance to activate or suspend."/>
  ],

  <@lib.requestBody
      mediaType = "application/json"
      dto = "SuspensionStateDto" />

  "responses" : {

    <@lib.response
        code = "204"
        last = true
        desc = "Request successful." />

      }
}