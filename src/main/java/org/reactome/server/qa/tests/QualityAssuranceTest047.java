package org.reactome.server.qa.tests;

import org.reactome.server.qa.QATest;

/**
 * Created by:
 *
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @since 18.03.16.
 */
@SuppressWarnings("unused")
@QATest
public class QualityAssuranceTest047 extends QualityAssuranceAbstract {

    @Override
    String getName() {
        return "OrphanEventsComputationalInferred";
    }

    @Override
    String getQuery() {
        return "Match (n:Event) OPTIONAL MATCH (n)<-[:created]-(a) WITH n,a WHERE NOT (n)<-[:hasEvent]-() " +
                "AND NOT (n:TopLevelPathway) AND n.isInferred = true Return DISTINCT(n.dbId) AS dbId, " +
                "n.displayName AS name, n.stId as stId, a.displayName AS author";
    }
}