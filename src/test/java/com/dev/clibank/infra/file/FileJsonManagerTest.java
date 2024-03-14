package com.dev.clibank.infra.file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import java.util.List;
import java.util.function.Predicate;

import com.dev.clibank.domain.Dummy;
import org.junit.jupiter.api.*;




public class FileJsonManagerTest {

    private static final String TEST_FILE = "test.json";

    @BeforeEach
    public void setUp() {
        FileJsonManager.clearFileJson(TEST_FILE);
    }

    @AfterEach
    public void tearDown() {
        FileJsonManager.clearFileJson(TEST_FILE);
    }

    @Test
    public void testSaveFileJsonAndGetFileListJson() {
        // Testa salvar um objeto em um arquivo JSON e então recuperá-lo

        // Dados de teste
        Dummy object1 = new Dummy("obj1");
        Dummy object2 = new Dummy("obj2");

        // Salva os objetos em um arquivo JSON
        FileJsonManager.saveFileJson(List.of(object1, object2), TEST_FILE);

        // Recupera a lista de objetos do arquivo JSON
        List<Dummy> resultList = FileJsonManager.getFileListJson(TEST_FILE, Dummy.class);

        // Verifica se os objetos foram recuperados corretamente
        assertEquals(2, resultList.size());
        assertEquals(object1.getName(), resultList.get(0).getName());
        assertEquals(object2.getName(), resultList.get(1).getName());
    }

    @Test
    public void testUpdatedFileJson() {
        // Testa a atualização de um objeto em um arquivo JSON

        // Dados de teste
        Dummy object1 = new Dummy("obj1");
        Dummy object2 = new Dummy("obj2");
        Dummy updatedObject = new Dummy("updatedObj");

        // Salva os objetos em um arquivo JSON
        FileJsonManager.saveFileJson(List.of(object1, object2), TEST_FILE);

        // Atualiza um objeto no arquivo JSON
        updatedObject.setName("obj1");
        Predicate<Dummy> predicate = obj -> obj.getName().equals("obj1");
        FileJsonManager.updatedFileJson(TEST_FILE, updatedObject, object1, predicate, Dummy.class);

        // Recupera a lista de objetos atualizada do arquivo JSON
        List<Dummy> resultList = FileJsonManager.getFileListJson(TEST_FILE, Dummy.class);

        // Verifica se o objeto foi atualizado corretamente
        assertEquals(2, resultList.size());
        assertEquals(updatedObject.getName(), "obj1");
        assertEquals(object2.getName(), "obj2");
    }

    @Test
    public void testFileArrayJsonToClass() throws FileNotFoundException {
        Dummy dummy = new Dummy("Joao");
        Dummy dummy2 = new Dummy("Carlos");
        FileJsonManager.saveFileJson(List.of(dummy, dummy2), TEST_FILE);

        List<Dummy> listedDummy = FileJsonManager.getFileListJson(TEST_FILE, Dummy.class);
        listedDummy.stream().forEach(dummyObject -> assertEquals(dummyObject.getClass(), Dummy.class));
    }


    @Test
    public void testInsertNewObject() throws FileNotFoundException {
        Dummy dummy = new Dummy("Joao");
        FileJsonManager.saveFileJson(List.of(dummy), TEST_FILE);
        Dummy dummy2 = new Dummy("Carlos");
        FileJsonManager.updatedFileJson(TEST_FILE,dummy2, Dummy.class);
        List<Dummy> listedDummy = FileJsonManager.getFileListJson(TEST_FILE, Dummy.class);
        assertEquals(listedDummy.size(), 2);
    }



}
