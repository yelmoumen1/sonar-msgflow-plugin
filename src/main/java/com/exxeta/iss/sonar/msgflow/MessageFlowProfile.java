/*
 * Sonar Message Flow Plugin
 * Copyright (C) 2015 Hendrik Scholz and EXXETA AG
 * http://www.exxeta.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.exxeta.iss.sonar.msgflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.Rule;
import org.sonar.api.utils.ValidationMessages;


/*Replaced ProfileDefinition by BuiltInQualityProfilesDefinition
Replaced RulesProfile by NewBuiltInQualityProfile
Replaced ValidationMessages by org.sonar.api.utils.log.Logger*/

/**
 * The class creates a profile and adds the existing rules to the created profile.
 * 
 * @author Hendrik Scholz (EXXETA AG)
 */

public class MessageFlowProfile implements BuiltInQualityProfilesDefinition {
	
	/**
	 * The logger for the class.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(MessageFlowProfile.class);
	
	/* (non-Javadoc)
	 * @see org.sonar.api.profiles.ProfileDefinition#createProfile(org.sonar.api.utils.ValidationMessages)
	 */
	/**
	 * The method creates a new profile. The defined rules are activated in the method.
	 * 
	 * @return a new RulesProfile
	 */
	@Override
	public void define(Context context) {
		LOG.debug("create profile");
		NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(MessageFlowCheckList.SONAR_WAY_PROFILE, MessageFlowLanguage.KEY);
		profile.setDefault(true);

		/*NewBuiltInActiveRule rule1 = profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY,  "CollectorNodeControlTerminal");
		//rule1.overrideSeverity("BLOCKER");
		NewBuiltInActiveRule rule2 = profile.activateRule(REPO_KEY, FlagLine2Rule.RULE_KEY);
		rule2.overrideSeverity("MAJOR");
		NewBuiltInActiveRule rule3 = profile.activateRule(REPO_KEY, FlagLine3Rule.RULE_KEY);
		rule3.overrideSeverity("CRITICAL");*/
		

		/* CollectorNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "CollectorNodeControlTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "CollectorNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "CollectorNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "CollectorNodeExpireTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "CollectorNodeCatchTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "CollectorNodeMonitoringEvents");
		
		/* ComputeNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ComputeNodeInTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ComputeNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ComputeNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ComputeNodeMonitoringEvents");
		
		/* File Input Node rules */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeOutTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeEODTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeCatchTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeBuildTree");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeRetainMixedContent");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeRetainComments");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeValidation");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeMessageDomain");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeMessageSet");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileInputNodeMonitoringEvents");
		
		/* FileOutputNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileOutputNodeInTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileOutputNodeInEODTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileOutputNodeFailureTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileOutputNodeOutTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileOutputNodeOutEODTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileOutputNodeValidation");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FileOutputNodeMonitoringEvents");

		/* HttpInputNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeTimeoutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeCatchTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeBuildTree");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeRetainMixedContent");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeRetainComments");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeValidation");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeMessageDomain");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeMessageSet");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpInputNodeMonitoringEvents");

		/* HttpRequestNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeHTTPHeader");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeMessageLocationTree");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeInTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeErrorTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeBuildTree");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeRetainMixedContent");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeRetainComments");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeValidation");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeMessageDomain");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeMessageSet");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpRequestNodeMonitoringEvents");
		
		/* MQInputNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeCatchTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeBuildTree");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeRetainMixedContent");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeRetainComments");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeValidation");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeMessageDomain");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeMessageSet");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQInputNodeMonitoringEvents");

		/* MQOutputNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQOutputNodeInTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQOutputNodeFailureTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQOutputNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQOutputNodeValidation");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQOutputNodeMonitoringEvents");

		/* ResetContentDescriptorNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ResetContentDescriptorNodeMessageDomain");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ResetContentDescriptorNodeMessageSet");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ResetContentDescriptorNodeResetMessageDomain");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ResetContentDescriptorNodeResetMessageSet");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ResetContentDescriptorNodeResetMessageType");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ResetContentDescriptorNodeResetMessageFormat");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ResetContentDescriptorNodeMonitoringEvents");

		/* SoapInputNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapInputNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapInputNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapInputNodeTimeoutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapInputNodeCatchTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapInputNodeBuildTree");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapInputNodeValidation");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapInputNodeMonitoringEvents");

		/* SoapRequestNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapRequestNodeInTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapRequestNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapRequestNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapRequestNodeFaultTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapRequestNodeBuildTree");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapRequestNodeValidation");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapRequestNodeMonitoringEvents");

		/* TimeoutControlNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TimeoutControlNodeInTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TimeoutControlNodeFailureTerminal");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TimeoutControlNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TimeoutControlNodeMonitoringEvents");

		/* TimeoutNotificationNode */
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TimeoutNotificationNodeFailureTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TimeoutNotificationNodeOutTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TimeoutNotificationNodeCatchTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TimeoutNotificationNodeMonitoringEvents");

		/* TryCatchNode */
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TryCatchNodeTryCatch");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TryCatchNodeInTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TryCatchNodeTryTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TryCatchNodeCatchTerminal");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TryCatchNodeMonitoringEvents");
		
		/* Below rules are being added here*/
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SelfConnectingNodes");
//		MQ Node names should match the under laying queue name - (Not active rule. Activate if applicable)
//		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQNodeNameMatchesQueueName");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "IMSRequestDescription");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "IMSRequestNodeDefinedProperties");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "IMSRequestCommitMode");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "IMSRequestMessageDomain");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MessageFlowDescription");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQHeaderNodeDetection");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FilterNodeNameCheck");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "IMSRequestNodeName");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQNodeTxnMode");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpReplyIgnoreTransportFailuresCheck");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "HttpReplyGenerateDefaultHttpHeadersCheck");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "ComputeNodeNameCheck");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "TraceNodeDetection");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "XMLNSCoverXMLNS");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "DisconnectedNode");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MQReplyWithoutMQInput");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "LabelWithoutConnections");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "AllInputTerminalsNotConnected");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "LabelWithoutRouteTo");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "FilterNodeConnection");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SoapRequestTimeOut");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MessageFlowInconsistentReply");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "SOAPAsyncNodeFault");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "aggregateControlNodeTimeout");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "NodeNameModuleName");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "OneModuleMultipleNodes");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "NodeLevelAdditionalInstances");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "UnusedSubFlow");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "mappingNodePropertiesMissing");
		//profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "todoFoundInMapping");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "queueNamingConvention");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "InconsistentRouteNode");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "DeprecatedNodeCheck");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "DSNWithoutDBCall");
		profile.activateRule(MessageFlowCheckList.REPOSITORY_KEY, "MavenProjectNamingConventions");
		// add more rules here
		
		LOG.debug("created profile: " + profile.toString());
		
		profile.done();
	}

}
