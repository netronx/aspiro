package com.aspiro.notification.domain.dto;

import java.time.LocalDateTime;

public record PostDTO(Long id, String title, String content, LocalDateTime createdAt, Long profileId) { }
