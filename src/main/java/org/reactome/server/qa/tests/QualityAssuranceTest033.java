package org.reactome.server.qa.tests;

import org.neo4j.ogm.model.Result;
import org.reactome.server.qa.QATest;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by:
 *
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @since 08.03.16.
 */
@SuppressWarnings("unused")
@QATest
public class QualityAssuranceTest033 extends QualityAssuranceAbstract {

    @Override
    String getName() {
        return "OtherRelationsThatPointToTheSameEntry";
    }

    @Override
    String getQuery() {
        return "Match (n)-[r]->(x),(n)-[e]->(x),(n)<-[:created]-(a) " +
                "WHERE NOT (n)-[:author|created|edited|modified|revised|reviewed|input|output|entityOnOtherCell|" +
                "hasComponent|requiredInputComponent|physicalEntity|activeUnit|reverseReaction|precedingEvent|hasEvent|" +
                "goCellularComponent|compartment|referenceSequence|secondReferenceSequence|hasCandidate|hasMember]-(x) " +
                "RETURN DISTINCT(n.dbId) AS dbIdA,n.stId AS stIdA, n.displayName AS nameA, x.dbId AS dbIdB, " +
                "x.stId AS stIdB, x.displayName AS nameB, a.displayName AS author";
    }

    @Override
    void printResult(Result result, Path path) throws IOException {
        print(result,path,"dbIdA","stIdA","nameA","dbIdB","stIdB","nameB","author");
    }
}

