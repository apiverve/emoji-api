# Emoji Lookup API - PHP Package

Emoji is a simple tool for getting emoji data. It returns the emoji name, category, and more.

## Installation

Install via Composer:

```bash
composer require apiverve/emoji
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Emoji\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['emoji' => '🥳']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Emoji\Client;
use APIVerve\Emoji\Exceptions\APIException;
use APIVerve\Emoji\Exceptions\ValidationException;

try {
    $response = $client->execute(['emoji' => '🥳']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/emoji?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/emoji?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/emoji?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
