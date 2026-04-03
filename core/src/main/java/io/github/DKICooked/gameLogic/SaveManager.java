package io.github.DKICooked.gameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

public class SaveManager {
    private static final String SAVE_FILE = "save.json";
    private static Json json = new Json();

    public static void save(SaveData data) {
        FileHandle file = Gdx.files.local("save.json");

        // This will print the EXACT path on your Windows C: drive
        System.out.println("DEBUG: Save file is at -> " + file.file().getAbsolutePath());

        json.setOutputType(JsonWriter.OutputType.json);
        file.writeString(json.prettyPrint(data), false);
    }

    public static SaveData load() {
        FileHandle file = Gdx.files.local(SAVE_FILE);
        if (file.exists()) {
            try {
                // Tell JSON to be "Ignore unknown fields"
                json.setIgnoreUnknownFields(true);
                return json.fromJson(SaveData.class, file.readString());
            } catch (Exception e) {
                System.err.println("Save file corrupted or old. Resetting.");
                return new SaveData(); // Return fresh data if it still fails
            }
        }
        return new SaveData();
    }
}
