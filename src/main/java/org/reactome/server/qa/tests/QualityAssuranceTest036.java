package org.reactome.server.qa.tests;

import org.neo4j.ogm.model.Result;
import org.reactome.server.qa.QATest;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by:
 *
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @since 14.03.16.
 */
@SuppressWarnings("unused")
@QATest
public class QualityAssuranceTest036 extends QualityAssuranceAbstract {

    @Override
    Boolean doTest() {
        return false;
    }

    @Override
    String getName() {
        return "AuthorRelationshipDuplication";
    }

    @Override
    String getQuery() {
        return "Match (x)<-[r:author]-(y) OPTIONAL MATCH (x)<-[:created]-(a) WITH x,y,r,a WHERE r.stoichiometry > 1 " +
                "Return DISTINCT(x.dbId) AS dbIdA, x.displayName AS nameA, y.dbId AS dbIdB, y.displayName AS nameB, a.displayName AS author";
    }

    @Override
    void printResult(Result result, Path path) throws IOException {
        print(result,path,"dbIdA","nameA","dbIdB","nameB","author");
    }
}