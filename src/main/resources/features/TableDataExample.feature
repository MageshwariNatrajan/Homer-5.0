@TableData
Feature: Feature to show Table data examples

@TableData1
Scenario: Table Data No Iteration Examples
Given I test Table Data with no parameter step
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test Table Data with parameter "hammer" step
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test two column data table map feature with parameter "hammer" step
|FirstName|Prashant|
|LastName |Sajjan  |
|City     |Austin  |
Given I test type cast List of String with no parameter step
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test type cast List of String with parameter "hammer" and "sink" step
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test type cast List of Map with no parameter step
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test type cast List of Map with parameter "hammer" and "sink" step
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test type cast List of Your Type with no parameter step
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test type cast List of Your Type with parameter "hammer" and "sink" step
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test type cast Map of String with no parameter step
|FirstName|Prashant|
|LastName |Sajjan  |
|City     |Austin  |
Given I test type cast Map of String with parameter "hammer" and "sink" step
|FirstName|Prashant|
|LastName |Sajjan  |
|City     |Austin  |

Scenario Outline:Table Data Iteration Examples
Given I test Table Data with parameter "hammer"
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test type cast List of Your Type with parameter "hammer" and "sink" and data <Email> and <Password>
| order           | credit        | gift    | status  |
| STH             | VISA          | no GIFT | success |
| BOSS            | MASTER        | no GIFT | success |
| BOPIS           | AMEX          | no GIFT | success |
Given I test type cast Map of String with no parameter step
|FirstName|Prashant|
|LastName |Sajjan  |
|City     |Austin  |
Then I test Hash Map Data
|Email|<Email>|
|Password|<Password>|
Examples: Data
|Email|Password|
|p.s@gmail.com|test123|
|homer@homedepot.com|homer123|