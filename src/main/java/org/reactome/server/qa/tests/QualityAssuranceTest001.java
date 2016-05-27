package org.reactome.server.qa.tests;

import org.reactome.server.qa.QATest;

/**
 * Created by:
 *
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @since 04.03.16.
 */
@SuppressWarnings("unused")
@QATest
public class QualityAssuranceTest001 extends QualityAssuranceAbstract {

    @Override
    String getName() {
        return "DatabaseObjectsWithSelfLoops";
    }

    @Override
    String getQuery() {
        return "Match (n)-[r]-(m),(n)-[:created]-(a) WHERE n=m RETURN  DISTINCT (n.dbId) AS dbId,n.stId AS stId, " +
                "n.displayName AS name, a.displayName AS author";
    }

}
