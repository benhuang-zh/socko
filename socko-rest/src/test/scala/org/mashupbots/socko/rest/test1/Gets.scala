//
// Copyright 2013 Vibul Imtarnasan, David Bolton and Socko contributors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
package org.mashupbots.socko.rest.test1

import org.mashupbots.socko.rest.RestGet
import org.mashupbots.socko.rest.RestRequest
import org.mashupbots.socko.rest.RestRequestContext
import org.mashupbots.socko.rest.RestResponse
import org.mashupbots.socko.rest.RestResponseContext

@RestGet(
  uriTemplate = "/pets",
  actorPath = "/my/actor/path")
case class GetPetsRequest(context: RestRequestContext) extends RestRequest {

}

case class GetPetsResponse(context: RestResponseContext) extends RestResponse {

}

@RestGet(
  uriTemplate = "/dogs1",
  actorPath = "/my/actor/path",
  responseClass = "GetFunnyNameDogResponse")
case class GetDogs1Request(context: RestRequestContext) extends RestRequest {

}

@RestGet(
  uriTemplate = "/dogs2",
  actorPath = "/my/actor/path",
  responseClass = "org.mashupbots.socko.rest.test1.GetFunnyNameDogResponse",
  errorResponses = Array("400=username not found", "401=yet another error"))
case class GetDogs2Request(context: RestRequestContext) extends RestRequest {

}

case class GetFunnyNameDogResponse(context: RestResponseContext) extends RestResponse {

}

// Ignored because there is no corresponding response class
@RestGet(
  uriTemplate = "/noresponse",
  actorPath = "/my/actor/path")
case class NoResponseRequest(context: RestRequestContext) extends RestRequest

// Ignored because this does not have a @RestGet
case class NoDeclarationRequest(context: RestRequestContext) extends RestRequest

// Ignored because not a RestRequest
case class NotARestClass()