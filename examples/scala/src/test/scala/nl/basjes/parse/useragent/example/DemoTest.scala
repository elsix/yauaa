/*
 * Yet Another UserAgent Analyzer
 * Copyright (C) 2013-2020 Niels Basjes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.basjes.parse.useragent.example

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FlatSpec

@RunWith(classOf[JUnitRunner])
class DemoTest extends FlatSpec {
  "The parser" must "extract the correct DeviceName" in {
    val demo = new Demo()

    val userAgent = "Mozilla/5.0 (Linux; Android 7.0; Nexus 6 Build/NBD90Z) " +
      "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.124 Mobile Safari/537.36"

    val result = demo.parse(userAgent)

    assert(result.toXML.contains("<DeviceName>Google Nexus 6</DeviceName>"))
  }
}
