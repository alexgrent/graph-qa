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
public class QualityAssuranceTest013 extends QualityAssuranceAbstract {

    @Override
    String getName() {
        return "ReferenceEntityWithoutIdentifier";
    }

    @Override
    String getQuery() {
        return "Match (n:ReferenceEntity)<-[:created]-(a) Where n.identifier is NULL RETURN n.dbId AS dbId, " +
                "n.stId AS stId, n.displayName AS name, a.displayName as author";
    }
}