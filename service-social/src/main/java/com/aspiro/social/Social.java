package com.aspiro.social;

import java.time.LocalDateTime;

public record Social(int id, LocalDateTime name, int userId, int amount) {
}
