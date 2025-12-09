// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     EmojiLookupData data = Converter.fromJsonString(jsonString);

package com.apiverve.emoji.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static EmojiLookupData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(EmojiLookupData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(EmojiLookupData.class);
        writer = mapper.writerFor(EmojiLookupData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// EmojiLookupData.java

package com.apiverve.emoji.data;

import com.fasterxml.jackson.annotation.*;

public class EmojiLookupData {
    private long count;
    private EmojisFound[] emojisFound;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("emojisFound")
    public EmojisFound[] getEmojisFound() { return emojisFound; }
    @JsonProperty("emojisFound")
    public void setEmojisFound(EmojisFound[] value) { this.emojisFound = value; }
}

// EmojisFound.java

package com.apiverve.emoji.data;

import com.fasterxml.jackson.annotation.*;

public class EmojisFound {
    private String emoji;
    private String description;
    private String category;
    private String[] aliases;
    private String[] tags;
    private String unicodeVersion;
    private String iosVersion;
    private String codePoint;

    @JsonProperty("emoji")
    public String getEmoji() { return emoji; }
    @JsonProperty("emoji")
    public void setEmoji(String value) { this.emoji = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("category")
    public String getCategory() { return category; }
    @JsonProperty("category")
    public void setCategory(String value) { this.category = value; }

    @JsonProperty("aliases")
    public String[] getAliases() { return aliases; }
    @JsonProperty("aliases")
    public void setAliases(String[] value) { this.aliases = value; }

    @JsonProperty("tags")
    public String[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(String[] value) { this.tags = value; }

    @JsonProperty("unicode_version")
    public String getUnicodeVersion() { return unicodeVersion; }
    @JsonProperty("unicode_version")
    public void setUnicodeVersion(String value) { this.unicodeVersion = value; }

    @JsonProperty("ios_version")
    public String getIosVersion() { return iosVersion; }
    @JsonProperty("ios_version")
    public void setIosVersion(String value) { this.iosVersion = value; }

    @JsonProperty("codePoint")
    public String getCodePoint() { return codePoint; }
    @JsonProperty("codePoint")
    public void setCodePoint(String value) { this.codePoint = value; }
}