package com.utopiacloud.themyscira.themyscira.domain.entity

import java.util.*
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
        var name: String,
        /** 組織情報（公開用電話番号） **/
        var tel: String,
        /** 組織情報（ファックス） **/
        var fax: String,
        /** 組織情報（ホームページ） **/
        var homepage: String,
        /** 組織情報（メールアドレス） **/
        var email: String,
        /** 組織情報（常勤職員数） **/
        var fullTimeMembers: String,
        /** 組織情報（事業活動の内容） **/
        var activitySummary: String,


        /** 事業年度（直近の決算） **/
        var currentBusinessYear: Int,
        /** 活動計画書 経常収益計-特定非営利活動に係る事業 **/
        var ordinalyIncomeMain: Long,
        /** 活動計画書 経常収益計-その他の事業 **/
        var ordinalyIncomeOthers: Long,
        /** 活動計画書 経常収益計-合計 **/
        var ordinalyIncomeTotal: Long,
        /** 活動計画書 経常収益計（受取会費）-特定非営利活動に係る事業 **/
        var ordinalyIncomeMembershipFeeMain: Long,
        /** 活動計画書 経常収益計（受取会費）-その他の事業 **/
        var ordinalyIncomeMembershipFeeOthers: Long,
        /** 活動計画書 経常収益計（受取会費）-合計 **/
        var ordinalyIncomeMembershipFeeTotal: Long,
        /** 活動計画書 経常収益計（受取寄附金）-特定非営利活動に係る事業 **/
        var ordinalyIncomeCotributionMain: Long,
        /** 活動計画書 経常収益計（受取寄附金）-その他の事業 **/
        var ordinalyIncomeCotributionOthers: Long,
        /** 活動計画書 経常収益計（受取寄附金）-合計 **/
        var ordinalyIncomeCotributionTotal: Long,
        /** 活動計画書 経常収益計（受取助成金等）-特定非営利活動に係る事業 **/
        var ordinalyIncomeSubsidyMain: Long,
        /** 活動計画書 経常収益計（受取助成金等）-その他の事業 **/
        var ordinalyIncomeSubsidyOthers: Long,
        /** 活動計画書 経常収益計（受取助成金等）-合計 **/
        var ordinalyIncomeSubsidyTotal: Long,
        /** 活動計画書 経常収益計（事業収益）-特定非営利活動に係る事業 **/
        var ordinalyIncomeBusinessMain: Long,
        /** 活動計画書 経常収益計（事業収益）-その他の事業 **/
        var ordinalyIncomeBusinessOthers: Long,
        /** 活動計画書 経常収益計（事業収益）-合計 **/
        var ordinalyIncomeBusinessTotal: Long,
        /** 活動計画書 経常収益計（その他収益）-特定非営利活動に係る事業 **/
        var ordinalyIncomeOthersMain: Long,
        /** 活動計画書 経常収益計（その他収益）-その他の事業 **/
        var ordinalyIncomeOthersOthers: Long,
        /** 活動計画書 経常収益計（その他収益）-合計 **/
        var ordinalyIncomeOthersTotal: Long,

        /** 活動計画書 経常費用計-特定非営利活動に係る事業 **/
        var ordinalyExpenseMain: Long,
        /** 活動計画書 経常費用計-その他の事業 **/
        var ordinalyExpenseOthers: Long,
        /** 活動計画書 経常費用計-合計 **/
        var ordinalyExpenseTotal: Long,
        /** 活動計画書 経常費用計（事業費）-特定非営利活動に係る事業 **/
        var ordinalyExpenseOperationMain: Long,
        /** 活動計画書 経常費用計（事業費）-その他の事業 **/
        var ordinalyExpenseOperationOthers: Long,
        /** 活動計画書 経常費用計（事業費）-合計 **/
        var ordinalyExpenseOperationTotal: Long,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-特定非営利活動に係る事業 **/
        var ordinalyExpenseOperationPersonalMain: Long,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-その他の事業 **/
        var ordinalyExpenseOperationPersonalOthers: Long,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-合計 **/
        var ordinalyExpenseOperationPersonalTotal: Long,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-特定非営利活動に係る事業 **/
        var ordinalyExpenseOperationOthersMain: Long,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-その他の事業 **/
        var ordinalyExpenseOperationOthersOthers: Long,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-合計 **/
        var ordinalyExpenseOperationOthersTotal: Long,
        /** 活動計画書 経常費用計（管理費）-特定非営利活動に係る事業 **/
        var ordinalyExpenseAdministrativeMain: Long,
        /** 活動計画書 経常費用計（管理費）-その他の事業 **/
        var ordinalyExpenseAdministrativeOthers: Long,
        /** 活動計画書 経常費用計（管理費）-合計 **/
        var ordinalyExpenseAdministrativeTotal: Long,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-特定非営利活動に係る事業 **/
        var ordinalyExpenseAdministrativePersonalMain: Long,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-その他の事業 **/
        var ordinalyExpenseAdministrativePersonalOthers: Long,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-合計 **/
        var ordinalyExpenseAdministrativeTotalOthers: Long,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-特定非営利活動に係る事業 **/
        var ordinalyExpenseAdministrativeOthersMain: Long,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-その他の事業 **/
        var ordinalyExpenseAdministrativeOthersOthers: Long,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-合計 **/
        var ordinalyExpenseAdministrativeOthersTotal: Long,

        /** 活動計画書 当期経常増減額-特定非営利活動に係る事業 **/
        var ordinalRiseOrFallMain: Long,
        /** 活動計画書 当期経常増減額-その他の事業 **/
        var ordinalRiseOrFallOthers: Long,
        /** 活動計画書 当期経常増減額-合計 **/
        var ordinalRiseOrFallTotal: Long,

        /** 活動計画書 経常外収益計-特定非営利活動に係る事業 **/
        var nonRecurringProfitMain: Long,
        /** 活動計画書 経常外収益計-その他の事業 **/
        var nonRecurringProfitOthers: Long,
        /** 活動計画書 経常外収益計-合計 **/
        var nonRecurringProfitTotal: Long,

        /** 活動計画書 経常外費用計-特定非営利活動に係る事業 **/
        var nonRecurringExpenseMain: Long,
        /** 活動計画書 経常外費用計-その他の事業 **/
        var nonRecurringExpenseOthers: Long,
        /** 活動計画書 経常外費用計-合計 **/
        var nonRecurringExpenseTotal: Long,

        /** 活動計画書 経理区分振替額-特定非営利活動に係る事業 **/
        var accountingClassificationTransferAmountMain: Long,
        /** 活動計画書 経理区分振替額-その他の事業 **/
        var accountingClassificationTransferAmountOthers: Long,
        /** 活動計画書 経理区分振替額-合計 **/
        var accountingClassificationTransferAmountTotal: Long,

        /** 活動計画書 当期正味財産増減額-特定非営利活動に係る事業 **/
        var netAssetRiseOrFallMainMain: Long,
        /** 活動計画書 当期正味財産増減額-その他の事業 **/
        var netAssetRiseOrFallMainOthers: Long,
        /** 活動計画書 当期正味財産増減額-合計 **/
        var netAssetRiseOrFallMainTotal: Long,

        /** 活動計画書 前期繰越正味財産額-特定非営利活動に係る事業 **/
        var previousTermNetAssetMain: Long,
        /** 活動計画書 前期繰越正味財産額-その他の事業 **/
        var previousTermNetAssetOthers: Long,
        /** 活動計画書 前期繰越正味財産額-合計 **/
        var previousTermNetAssetTotal: Long,

        /** 活動計画書 次期繰越正味財産額-特定非営利活動に係る事業 **/
        var nextTermNetAssetMain: Long,
        /** 活動計画書 次期繰越正味財産額-その他の事業 **/
        var nextTermNetAssetOthers: Long,
        /** 活動計画書 次期繰越正味財産額-合計 **/
        var nextTermNetAssetTotal: Long,


        /** 貸借対照表 時点 **/
        var bsTime: Date,
        /** 貸借対照表 資産の部（流動資産） **/
        var bsCurrentAssets: Long,
        /** 貸借対照表 資産の部（固定資産） **/
        var bsFixedAssets: Long,
        /** 貸借対照表 資産の部（資産合計） **/
        var bsTotalAssets: Long,
        /** 貸借対照表 負債の部（流動負債） **/
        var bsCurrentDebt: Long,
        /** 貸借対照表 負債の部（固定負債） **/
        var bsFixedDebt: Long,
        /** 貸借対照表 負債の部（負債合計） **/
        var bsTotalDebt: Long,
        /** 貸借対照表 正味財産の部（前期繰越正味財産） **/
        var bsPreviousTermNetAsset: Long,
        /** 貸借対照表 正味財産の部（当期繰越正味財産） **/
        var bsCurrentTermNetAsset: Long,
        /** 貸借対照表 正味財産の部（正味財産合計） **/
        var bsTotalNetAsset: Long,
        /** 貸借対照表 負債及び正味財産合計 **/
        var bsTotalAmount: Long,

        /** 準拠している会計基準１ **/
        var conformingAccountingStandards1: Int,
        /** 準拠している会計基準２ **/
        var conformingAccountingStandards2: Int,
        /** 準拠している会計基準３ **/
        var conformingAccountingStandards3: Int,
        /** 準拠している会計基準４ **/
        var conformingAccountingStandards4: Int,
        /** 準拠している会計基準５ **/
        var conformingAccountingStandards5: Int,
        /** 準拠している会計基準（その他） **/
        var conformingAccountingStandardsOthers: Int,


        /** 監査の実施１ **/
        var auditConduction1: String,
        /** 監査の実施２ **/
        var auditConduction2: String,
        /** 監査の実施３ **/
        var auditConduction3: String
)