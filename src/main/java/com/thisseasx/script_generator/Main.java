package com.thisseasx.script_generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        String[] classesBefore = new String[]{
                "GamingFraudRulesOccurrenceType",
                "GamingFraudRulesStatuses",
                "GamingFraudRulesTrigger",
                "GamingGameDrawNotificationTypes",
                "GamingGameManufacturerChannelTypes",
                "GamingGameManufacturersImportType",
                "GamingGameOutcomeTypeOptions",
                "GamingGameOutcomeTypes",
                "GamingGamePlaysDeviceTypes",
                "GamingGameProviderWinStatuses",
                "GamingGameProviderWinStatusesLicenses",
                "GamingGameRoundTypes",
                "GamingGameSessionTypes",
                "GamingGameStartType",
                "GamingGameTypes",
                "GamingGroupWithdrawTypes",
                "GamingIntervalType",
                "GamingIssueWithdrawalTypes",
                "GamingJobExecutionStatuses",
                "GamingJobExecutionTypes",
                "GamingKycCheckedStatuses",
                "GamingKycDocumentStatuses",
                "GamingLanguages",
                "GamingLoyaltyBadgeTypes",
                "GamingLoyaltyPrizeTypes",
                "GamingLoyaltyRedemptionPrizeTypes",
                "GamingMessageTemplateVarTypes",
                "GamingMunicipalitiesTypes",
                "GamingNotificationMessageTypes",
                "GamingPaymentFileTypesPaymentTypes",
                "GamingPaymentMethodIntegrationTypes",
                "GamingPaymentTransactionStatus",
                "GamingPayoutTypes",
                "GamingPbCompetitionStatuses",
                "GamingPbFixturePoolHistoryType",
                "GamingPbFixtureStatuses",
                "GamingPbPoolStatuses",
                "GamingPbPoolTypes",
                "GamingPbStatuses",
                "GamingPendingWinningsStatuses",
                "GamingPlayConstraintAmountTypes",
                "GamingPlayLimitType",
                "GamingProfileTypes",
                "GamingQueryDateIntervalTypes",
                "GamingRetrieveDateTypes",
                "GamingRuleActionTypes",
                "GamingRuleActionTypesVarTypes",
                "GamingRulesEvents",
                "GamingSbBetTransactionTypes",
                "GamingSbBetTypes"
        };

        String[] classesAfter = new String[]{
                "GamingFraudRuleOccurrenceType",
                "GamingFraudRuleStatus",
                "GamingFraudRuleTrigger",
                "GamingGameDrawNotificationType",
                "GamingGameManufacturerChannelType",
                "GamingGameManufacturerImportType",
                "GamingGameOutcomeTypeOption",
                "GamingGameOutcomeType",
                "GamingGamePlayDeviceType",
                "GamingGameProviderWinStatus",
                "GamingGameProviderWinStatusLicense",
                "GamingGameRoundType",
                "GamingGameSessionType",
                "GamingGameStartType",
                "GamingGameType",
                "GamingGroupWithdrawType",
                "GamingIntervalType",
                "GamingIssueWithdrawalType",
                "GamingJobExecutionStatus",
                "GamingJobExecutionType",
                "GamingKycCheckedStatus",
                "GamingKycDocumentStatus",
                "GamingLanguage",
                "GamingLoyaltyBadgeType",
                "GamingLoyaltyPrizeType",
                "GamingLoyaltyRedemptionPrizeType",
                "GamingMessageTemplateVarType",
                "GamingMunicipalityType",
                "GamingNotificationMessageType",
                "GamingPaymentFileTypePaymentType",
                "GamingPaymentMethodIntegrationType",
                "GamingPaymentTransactionStatus",
                "GamingPayoutType",
                "GamingPbCompetitionStatus",
                "GamingPbFixturePoolHistoryType",
                "GamingPbFixtureStatus",
                "GamingPbPoolStatus",
                "GamingPbPoolType",
                "GamingPbStatus",
                "GamingPendingWinningStatus",
                "GamingPlayConstraintAmountType",
                "GamingPlayLimitType",
                "GamingProfileType",
                "GamingQueryDateIntervalType",
                "GamingRetrieveDateType",
                "GamingRuleActionType",
                "GamingRuleActionTypeVarType",
                "GamingRuleEvent",
                "GamingSbBetTransactionType",
                "GamingSbBetType"
        };

        File entityScripts = new File(System.getProperty("user.home") + "\\Desktop\\Scripts\\entity_scripts.ps");
        File mapScripts = new File(System.getProperty("user.home") + "\\Desktop\\Scripts\\map_scripts.ps");

        for (int i = 0; i < classesBefore.length; i++) {
            try (FileWriter fw = new FileWriter(entityScripts, true)) {
                fw.write(String.format(getTemplate("entity"), classesBefore[i], classesAfter[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < classesBefore.length; i++) {
            try (FileWriter fw = new FileWriter(mapScripts, true)) {
                fw.write(String.format(getTemplate("map"), classesBefore[i], classesAfter[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getTemplate(String type) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("template.properties")) {
            Properties props = new Properties();
            props.load(is);
            return props.getProperty("template." + type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
