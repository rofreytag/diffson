/*
* This file is part of the diffson project.
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
package gnieh.diffson

package object schema {

  lazy val EmptySchema: JsonSchema = JsonSchema(None,
    None,
    Map(),
    NumericSchema(None, None, false, None, false),
    StringSchema(None, 0, None),
    ArraySchema(Left(EmptySchema), Right(EmptySchema), None, 0, false),
    ObjectSchema(None, 0, None, Right(EmptySchema), Map(), Map(), Map()),
    AnySchema(None, None, None, None, None, None, Map()),
    MetadataSchema(None, None, None))

  val keywords = Set("multipleOf",
    "maximum",
    "exclusiveMaximum",
    "minimum",
    "exclusiveMinimum",
    "maxLength",
    "minLength",
    "pattern",
    "items",
    "additionalItems",
    "maxItems",
    "minItems",
    "uniqueItems",
    "maxProperties",
    "minProperties",
    "required",
    "additionalProperties",
    "properties",
    "patternProperties",
    "dependencies",
    "enum",
    "type",
    "allOf",
    "anyOf",
    "oneOf",
    "not",
    "definitions",
    "title",
    "description",
    "default")

  implicit class SchemaString(val str: String) extends AnyVal {

    def isKeyword: Boolean =
      keywords.contains(str)

  }

}
