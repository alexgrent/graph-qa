package org.reactome.server.qa.tests;

import org.reactome.server.qa.QATest;

/**
 * Created by:
 *
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @since 07.03.16.
 */
@SuppressWarnings("unused")
@QATest
public class QualityAssuranceTest008 extends QualityAssuranceAbstract {

    @Override
    String getName() {
        return "ReactionsWithoutInputOrOutput";
    }

    @Override
    String getQuery() {
        return "Match (n:Reaction)<-[:created]-(a) Where NOT (n)-[:output|input]->() RETURN n.dbId AS dbId, " +
                "n.stId AS stId, n.displayName AS name, a.displayName as author";
    }
}