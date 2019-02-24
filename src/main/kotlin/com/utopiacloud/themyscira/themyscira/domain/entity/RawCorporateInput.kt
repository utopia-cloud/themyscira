package com.utopiacloud.themyscira.themyscira.domain.entity

import java.lang.reflect.Field
import java.util.*
import java.util.stream.Collectors
import javax.persistence.*


/**
 *
 */
@Entity
@Table(name = "raw_corporate_input")
class RawCorporateInput(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,

        /** 法人名称 **/
        var name: String? = null,
        /** 組織情報（公開用電話番号） **/
        var tel: String? = null,
        /** 組織情報（ファックス） **/
        var fax: String? = null,
        /** 組織情報（ホームページ） **/
        var homepage: String? = null,
        /** 組織情報（メールアドレス） **/
        var email: String? = null,
        /** 組織情報（常勤職員数） **/
        var fullTimeMembers: String? = null,
        /** 組織情報（事業活動の内容） **/
        @Lob
        var activitySummary: String? = null,


        /** 事業年度（直近の決算） **/
        var currentBusinessYear: String? = null,
        /** 活動計画書 経常収益計-特定非営利活動に係る事業 **/
        var ordinaryIncomeMain: String? = null,
        /** 活動計画書 経常収益計-その他の事業 **/
        var ordinaryIncomeOthers: String? = null,
        /** 活動計画書 経常収益計-合計 **/
        var ordinaryIncomeTotal: String? = null,
        /** 活動計画書 経常収益計（受取会費）-特定非営利活動に係る事業 **/
        var ordinaryIncomeMembershipFeeMain: String? = null,
        /** 活動計画書 経常収益計（受取会費）-その他の事業 **/
        var ordinaryIncomeMembershipFeeOthers: String? = null,
        /** 活動計画書 経常収益計（受取会費）-合計 **/
        var ordinaryIncomeMembershipFeeTotal: String? = null,
        /** 活動計画書 経常収益計（受取寄附金）-特定非営利活動に係る事業 **/
        var ordinaryIncomeCotributionMain: String? = null,
        /** 活動計画書 経常収益計（受取寄附金）-その他の事業 **/
        var ordinaryIncomeCotributionOthers: String? = null,
        /** 活動計画書 経常収益計（受取寄附金）-合計 **/
        var ordinaryIncomeCotributionTotal: String? = null,
        /** 活動計画書 経常収益計（受取助成金等）-特定非営利活動に係る事業 **/
        var ordinaryIncomeSubsidyMain: String? = null,
        /** 活動計画書 経常収益計（受取助成金等）-その他の事業 **/
        var ordinaryIncomeSubsidyOthers: String? = null,
        /** 活動計画書 経常収益計（受取助成金等）-合計 **/
        var ordinaryIncomeSubsidyTotal: String? = null,
        /** 活動計画書 経常収益計（事業収益）-特定非営利活動に係る事業 **/
        var ordinaryIncomeBusinessMain: String? = null,
        /** 活動計画書 経常収益計（事業収益）-その他の事業 **/
        var ordinaryIncomeBusinessOthers: String? = null,
        /** 活動計画書 経常収益計（事業収益）-合計 **/
        var ordinaryIncomeBusinessTotal: String? = null,
        /** 活動計画書 経常収益計（その他収益）-特定非営利活動に係る事業 **/
        var ordinaryIncomeOthersMain: String? = null,
        /** 活動計画書 経常収益計（その他収益）-その他の事業 **/
        var ordinaryIncomeOthersOthers: String? = null,
        /** 活動計画書 経常収益計（その他収益）-合計 **/
        var ordinaryIncomeOthersTotal: String? = null,

        /** 活動計画書 経常費用計-特定非営利活動に係る事業 **/
        var ordinaryExpenseMain: String? = null,
        /** 活動計画書 経常費用計-その他の事業 **/
        var ordinaryExpenseOthers: String? = null,
        /** 活動計画書 経常費用計-合計 **/
        var ordinaryExpenseTotal: String? = null,
        /** 活動計画書 経常費用計（事業費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseOperationMain: String? = null,
        /** 活動計画書 経常費用計（事業費）-その他の事業 **/
        var ordinaryExpenseOperationOthers: String? = null,
        /** 活動計画書 経常費用計（事業費）-合計 **/
        var ordinaryExpenseOperationTotal: String? = null,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseOperationPersonalMain: String? = null,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-その他の事業 **/
        var ordinaryExpenseOperationPersonalOthers: String? = null,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-合計 **/
        var ordinaryExpenseOperationPersonalTotal: String? = null,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseOperationOthersMain: String? = null,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-その他の事業 **/
        var ordinaryExpenseOperationOthersOthers: String? = null,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-合計 **/
        var ordinaryExpenseOperationOthersTotal: String? = null,
        /** 活動計画書 経常費用計（管理費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseAdministrativeMain: String? = null,
        /** 活動計画書 経常費用計（管理費）-その他の事業 **/
        var ordinaryExpenseAdministrativeOthers: String? = null,
        /** 活動計画書 経常費用計（管理費）-合計 **/
        var ordinaryExpenseAdministrativeTotal: String? = null,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseAdministrativePersonalMain: String? = null,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-その他の事業 **/
        var ordinaryExpenseAdministrativePersonalOthers: String? = null,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-合計 **/
        var ordinaryExpenseAdministrativeTotalOthers: String? = null,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseAdministrativeOthersMain: String? = null,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-その他の事業 **/
        var ordinaryExpenseAdministrativeOthersOthers: String? = null,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-合計 **/
        var ordinaryExpenseAdministrativeOthersTotal: String? = null,

        /** 活動計画書 当期経常増減額-特定非営利活動に係る事業 **/
        var ordinalRiseOrFallMain: String? = null,
        /** 活動計画書 当期経常増減額-その他の事業 **/
        var ordinalRiseOrFallOthers: String? = null,
        /** 活動計画書 当期経常増減額-合計 **/
        var ordinalRiseOrFallTotal: String? = null,

        /** 活動計画書 経常外収益計-特定非営利活動に係る事業 **/
        var nonRecurringProfitMain: String? = null,
        /** 活動計画書 経常外収益計-その他の事業 **/
        var nonRecurringProfitOthers: String? = null,
        /** 活動計画書 経常外収益計-合計 **/
        var nonRecurringProfitTotal: String? = null,

        /** 活動計画書 経常外費用計-特定非営利活動に係る事業 **/
        var nonRecurringExpenseMain: String? = null,
        /** 活動計画書 経常外費用計-その他の事業 **/
        var nonRecurringExpenseOthers: String? = null,
        /** 活動計画書 経常外費用計-合計 **/
        var nonRecurringExpenseTotal: String? = null,

        /** 活動計画書 経理区分振替額-特定非営利活動に係る事業 **/
        var accountingClassificationTransferAmountMain: String? = null,
        /** 活動計画書 経理区分振替額-その他の事業 **/
        var accountingClassificationTransferAmountOthers: String? = null,
        /** 活動計画書 経理区分振替額-合計 **/
        var accountingClassificationTransferAmountTotal: String? = null,

        /** 活動計画書 当期正味財産増減額-特定非営利活動に係る事業 **/
        var netAssetRiseOrFallMain: String? = null,
        /** 活動計画書 当期正味財産増減額-その他の事業 **/
        var netAssetRiseOrFallOthers: String? = null,
        /** 活動計画書 当期正味財産増減額-合計 **/
        var netAssetRiseOrFallTotal: String? = null,

        /** 活動計画書 前期繰越正味財産額-特定非営利活動に係る事業 **/
        var previousTermNetAssetMain: String? = null,
        /** 活動計画書 前期繰越正味財産額-その他の事業 **/
        var previousTermNetAssetOthers: String? = null,
        /** 活動計画書 前期繰越正味財産額-合計 **/
        var previousTermNetAssetTotal: String? = null,

        /** 活動計画書 次期繰越正味財産額-特定非営利活動に係る事業 **/
        var nextTermNetAssetMain: String? = null,
        /** 活動計画書 次期繰越正味財産額-その他の事業 **/
        var nextTermNetAssetOthers: String? = null,
        /** 活動計画書 次期繰越正味財産額-合計 **/
        var nextTermNetAssetTotal: String? = null,


        /** 貸借対照表 時点 **/
        var bsTime: String? = null,
        /** 貸借対照表 資産の部（流動資産） **/
        var bsCurrentAssets: String? = null,
        /** 貸借対照表 資産の部（固定資産） **/
        var bsFixedAssets: String? = null,
        /** 貸借対照表 資産の部（資産合計） **/
        var bsTotalAssets: String? = null,
        /** 貸借対照表 負債の部（流動負債） **/
        var bsCurrentDebt: String? = null,
        /** 貸借対照表 負債の部（固定負債） **/
        var bsFixedDebt: String? = null,
        /** 貸借対照表 負債の部（負債合計） **/
        var bsTotalDebt: String? = null,
        /** 貸借対照表 正味財産の部（前期繰越正味財産） **/
        var bsPreviousTermNetAsset: String? = null,
        /** 貸借対照表 正味財産の部（当期繰越正味財産） **/
        var bsCurrentTermNetAsset: String? = null,
        /** 貸借対照表 正味財産の部（正味財産合計） **/
        var bsTotalNetAsset: String? = null,
        /** 貸借対照表 負債及び正味財産合計 **/
        var bsTotalAmount: String? = null,

        /** 準拠している会計基準１ **/
        var conformingAccountingStandards1: String? = null,
        /** 準拠している会計基準２ **/
        var conformingAccountingStandards2: String? = null,
        /** 準拠している会計基準３ **/
        var conformingAccountingStandards3: String? = null

        // TODO これ以下はヘッダーしかないっぽくカンマすらない(MacのNumbersのcountaで確認)
//        /** 準拠している会計基準４ **/
//        var conformingAccountingStandards4: String? = null,
//        /** 準拠している会計基準５ **/
//        var conformingAccountingStandards5: String? = null,
//        /** 準拠している会計基準（その他） **/
//        var conformingAccountingStandardsOthers: String? = null,
//
//
//        /** 監査の実施１ **/
//        var auditConduction1: String? = null,
//        /** 監査の実施２ **/
//        var auditConduction2: String? = null,
//        /** 監査の実施３ **/
//        var auditConduction3: String? = null
) {
    companion object {
        val csvHeader = Arrays.stream(RawCorporateInput::class.java.declaredFields)
                .map { t: Field -> t.name }
                .filter { s ->
                    !arrayOf(
                            "id",
                            "csvHeader",
                            "Companion"
                    ).contains(s)
                }
                .collect(Collectors.toList())
                .toTypedArray()
    }
}

