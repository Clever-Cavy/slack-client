package com.hubspot.slack.client.models.events;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hubspot.slack.client.models.events.json.EventDeserializer;

@JsonNaming(SnakeCaseStrategy.class)
@JsonDeserialize(using = EventDeserializer.class)
public interface SlackEvent {
  SlackEventType getType();
  String getTs();

  default <T extends SlackEvent> T toDetailedEvent() {
    return (T) this;
  }
}
