# Emoji Lookup API - Dart/Flutter Client

Emoji Lookup searches emoji characters, tags, or categories to return descriptive names and classifications. Query by raw symbol, keyword tag, or category to inspect matching emoji glyphs, text descriptions, and categories.

[![pub package](https://img.shields.io/pub/v/apiverve_emoji.svg)](https://pub.dev/packages/apiverve_emoji)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Emoji Lookup API](https://apiverve.com/marketplace/emoji?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_emoji: ^1.2.4
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_emoji/apiverve_emoji.dart';

void main() async {
  final client = EmojiClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'emoji': '🥳'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 1,
    "emojisFound": [
      {
        "emoji": "🥳",
        "description": "partying face",
        "category": "Smileys & Emotion",
        "aliases": [
          "partying_face"
        ],
        "tags": [
          "celebration",
          "birthday"
        ],
        "unicode_version": "11.0",
        "ios_version": "12.1",
        "codePoint": "1f973"
      }
    ]
  }
}
```

## API Reference

- **API Home:** [Emoji Lookup API](https://apiverve.com/marketplace/emoji?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/emoji](https://docs.apiverve.com/ref/emoji?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
