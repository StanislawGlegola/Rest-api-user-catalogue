package pl.sg.subscribers.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Subscribers {
    private long userId;
    private long subscribesToId;
}