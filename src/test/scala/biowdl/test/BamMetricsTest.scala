/*
 * Copyright (c) 2018 Biowdl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package biowdl.test

import java.io.File

import nl.biopet.utils.biowdl.annotations.TestAnnotation
import nl.biopet.utils.biowdl.references.TestReference
import nl.biopet.utils.biowdl.fixtureFile

import nl.biopet.utils.ngs.intervals.{BedRecord, BedRecordList}

class BamMetricsTest
    extends BamMetricsSuccess
    with TestReference
    with TestAnnotation {
  def bamFile: File = fixtureFile("samples", "wgs1", "wgs1.bam")
}

class BamMetricsRnaTest
    extends BamMetricsSuccess
    with TestReference
    with TestAnnotation {
  def bamFile: File = fixtureFile("samples", "rna3", "rna3.bam")
  override def rna: Boolean = true
}

class BamMetricsRnaStrandednessTest extends BamMetricsRnaTest {
  override def strandedness: Option[String] = Some("None")
}

class BamMetricsTargetedTest extends BamMetricsTest {
  override def ampliconIntervals: Option[File] =
    Some(fixtureFile("reference", "target.bed"))
  override def targetIntervals: Option[List[File]] =
    Some(List(fixtureFile("reference", "target.bed")))
}
//TODO targeted
