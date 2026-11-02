/// Response models for the Emoji Lookup API.

/// API Response wrapper.
class EmojiResponse {
  final String status;
  final dynamic error;
  final EmojiData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  EmojiResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory EmojiResponse.fromJson(Map<String, dynamic> json) => EmojiResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? EmojiData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Emoji Lookup API.

class EmojiData {
  num? count;
  List<EmojiDataEmojisfoundItem>? emojisFound;

  EmojiData({
    this.count,
    this.emojisFound,
  });

  factory EmojiData.fromJson(Map<String, dynamic> json) => EmojiData(
      count: json['count'],
      emojisFound: (json['emojisFound'] as List?)?.map((e) => EmojiDataEmojisfoundItem.fromJson(e)).toList(),
    );
}

class EmojiDataEmojisfoundItem {
  String? emoji;
  String? description;
  String? category;
  List<String>? aliases;
  List<String>? tags;
  String? unicodeVersion;
  String? iosVersion;
  String? codePoint;

  EmojiDataEmojisfoundItem({
    this.emoji,
    this.description,
    this.category,
    this.aliases,
    this.tags,
    this.unicodeVersion,
    this.iosVersion,
    this.codePoint,
  });

  factory EmojiDataEmojisfoundItem.fromJson(Map<String, dynamic> json) => EmojiDataEmojisfoundItem(
      emoji: json['emoji'],
      description: json['description'],
      category: json['category'],
      aliases: (json['aliases'] as List?)?.cast<String>(),
      tags: (json['tags'] as List?)?.cast<String>(),
      unicodeVersion: json['unicode_version'],
      iosVersion: json['ios_version'],
      codePoint: json['codePoint'],
    );
}

class EmojiRequest {
  String emoji;

  EmojiRequest({
    required this.emoji,
  });

  Map<String, dynamic> toJson() => {
      'emoji': emoji,
    };
}
