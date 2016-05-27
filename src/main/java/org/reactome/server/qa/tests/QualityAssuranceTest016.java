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
public class QualityAssuranceTest016 extends QualityAssuranceAbstract {

    @Override
    String getName() {
        return "CatalystActivityWithoutActivity";
    }

    @Override
    String getQuery() {
        return "Match (n:CatalystActivity)<-[:created]-(a) Where NOT (n)-[:activity]->() RETURN n.dbId AS dbId, " +
                "n.stId AS stId, n.displayName AS name, a.displayName as author";
    }

    @Override
    void printResult(Result result, Path path) throws IOException {
        print(result,path,"dbId","name","author");
    }
}