import AzureRM
import ClientConfiguration
import jetbrains.buildServer.configs.kotlin.v2019_2.*

version = "2020.2"

var clientId = DslContext.getParameter("clientId", "")
var clientSecret = DslContext.getParameter("clientSecret", "")
var subscriptionId = DslContext.getParameter("subscriptionId", "")
var subscriptionIdAlt = DslContext.getParameter("subscriptionIdAlt", "")
var subscriptionIdDevTest = DslContext.getParameter("subscriptionIdDevTest", "")
var tenantId = DslContext.getParameter("tenantId", "")
var environment = DslContext.getParameter("environment", "public")
var clientIdAlt = DslContext.getParameter("clientIdAlt", "")
var clientSecretAlt = DslContext.getParameter("clientSecretAlt", "")
var enableTestTriggersGlobally = DslContext.getParameter("enableTestTriggersGlobally", "true").equals("true", ignoreCase = true)

var clientConfig = ClientConfiguration(clientId, clientSecret, subscriptionId, tenantId, clientIdAlt, clientSecretAlt, subscriptionIdAlt, subscriptionIdDevTest, enableTestTriggersGlobally)

project(AzureRM(environment, clientConfig))
