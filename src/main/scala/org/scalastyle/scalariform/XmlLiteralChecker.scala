// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.scalastyle.scalariform

import org.langmeta.inputs.Position
import org.scalastyle.ColumnError
import org.scalastyle.ScalametaChecker
import org.scalastyle.ScalastyleError

import scala.meta.Term
import scala.meta.Tree

class XmlLiteralChecker extends ScalametaChecker {
  val errorKey = "xml.literal"

  final def verify(ast: Tree): List[ScalastyleError] = {
    VisitorHelper.getAllSm[Term.Xml](ast.children.head).map(t => toError(t.pos))
  }

  private def toError(p: Position): ScalastyleError = {
    p match {
      case Position.None => ???
      case r: Position.Range => ColumnError(r.startLine+1, r.startColumn)

    }
  }
}
